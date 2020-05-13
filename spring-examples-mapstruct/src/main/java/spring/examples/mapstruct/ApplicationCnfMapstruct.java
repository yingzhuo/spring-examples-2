package spring.examples.mapstruct;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.util.regex.Pattern;

@Configuration
@ComponentScan(
        basePackages = "spring.examples.mapstruct",
        useDefaultFilters = false,
        includeFilters = @ComponentScan.Filter(type = FilterType.CUSTOM, classes = ApplicationCnfMapstruct.MapperTypeFilter.class)
)
public class ApplicationCnfMapstruct {

    static class MapperTypeFilter implements TypeFilter {

        private final Pattern regex = Pattern.compile(".*MapperImpl");

        @Override
        public boolean match(MetadataReader reader, MetadataReaderFactory factory) {
            final ClassMetadata classMetadata = reader.getClassMetadata();
            final String className = classMetadata.getClassName();
            return !classMetadata.isInterface() && regex.matcher(className).matches();
        }
    }

}
