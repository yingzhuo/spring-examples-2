package spring.examples.scanning.x;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.*;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.util.ClassUtils;

import java.util.*;

@Slf4j
class EnableScanningConfiguration implements ImportBeanDefinitionRegistrar, ResourceLoaderAware, EnvironmentAware {

    private static final Class<EnableScanning> ENABLE_SCANNING_CLASS = EnableScanning.class;
    private static final String ENABLE_SCANNING_CLASS_NAME = ENABLE_SCANNING_CLASS.getName();
    private static final Class<Named> NAMED_CLASS = Named.class;

    private Environment environment;
    private ResourceLoader resourceLoader;

    @Override
    public void registerBeanDefinitions(
            AnnotationMetadata importingClassMetadata,
            BeanDefinitionRegistry registry,
            BeanNameGenerator beanNameGenerator) {
        final Set<String> basePackages = getBasePackages(importingClassMetadata);

        log.debug("base-packages:");
        for (String basePackage : basePackages) {
            log.debug("\t{}", basePackage);
        }

        final ClassPathScanningCandidateComponentProvider scanner = createScanner();
        for (String basePackage : basePackages) {
            Set<BeanDefinition> candidateComponents = scanner.findCandidateComponents(basePackage);

            for (BeanDefinition candidateComponent : candidateComponents) {
                if (candidateComponent instanceof AnnotatedBeanDefinition) {
                    AnnotatedBeanDefinition annotatedBeanDefinition = (AnnotatedBeanDefinition) candidateComponent;
                    doRegister(annotatedBeanDefinition, registry, beanNameGenerator);
                }
            }
        }
    }

    private void doRegister(AnnotatedBeanDefinition annotatedBeanDefinition, BeanDefinitionRegistry registry, BeanNameGenerator beanNameGenerator) {
        log.debug("{}", annotatedBeanDefinition.getBeanClassName());

        Map<String, Object> attrs = annotatedBeanDefinition.getMetadata().getAnnotationAttributes(NAMED_CLASS.getName());
        String name = (String) attrs.get("name");

        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(NameFactoryBean.class);
        beanDefinitionBuilder.addPropertyValue("name", name);
        beanDefinitionBuilder.setPrimary(false);
        beanDefinitionBuilder.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);

        AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        beanDefinition.setAttribute(FactoryBean.OBJECT_TYPE_ATTRIBUTE, Name.class);
        beanDefinition.setPrimary(false);

        BeanDefinitionHolder holder = new BeanDefinitionHolder(beanDefinition, UUID.randomUUID().toString(), new String[0]);
        BeanDefinitionReaderUtils.registerBeanDefinition(holder, registry);
    }

    private Set<String> getBasePackages(AnnotationMetadata metadata) {
        Set<String> basePackages = new HashSet<>();
        Map<String, Object> attrs = metadata.getAnnotationAttributes(ENABLE_SCANNING_CLASS_NAME);
        Collections.addAll(basePackages, (String[]) attrs.get("basePackages"));

        if (basePackages.isEmpty()) {
            basePackages.add(ClassUtils.getPackageName(metadata.getClassName()));
        }

        return Collections.unmodifiableSet(basePackages);
    }

    private ClassPathScanningCandidateComponentProvider createScanner() {
        return new ClassPathScanningCandidateComponentProvider(false, environment) {
            {
                super.setResourceLoader(resourceLoader);
                super.addIncludeFilter(new AnnotationTypeFilter(NAMED_CLASS));
            }

            @Override
            protected boolean isCandidateComponent(
                    AnnotatedBeanDefinition beanDefinition) {

                boolean isCandidate = false;
                if (beanDefinition.getMetadata().isIndependent()) {
                    if (!beanDefinition.getMetadata().isAnnotation()) {
                        isCandidate = true;
                    }
                }
                return isCandidate;
            }
        };
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

}
