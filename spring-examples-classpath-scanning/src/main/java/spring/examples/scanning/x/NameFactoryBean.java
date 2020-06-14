package spring.examples.scanning.x;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

class NameFactoryBean implements FactoryBean<Name>, ApplicationContextAware {

    private String name;

    @Override
    public Name getObject() {
        return new Name() {
            @Override
            public String getName() {
                return name;
            }

            @Override
            public String toString() {
                return name;
            }
        };
    }

    @Override
    public Class<?> getObjectType() {
        return Name.class;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("---");
    }

    public void setName(String name) {
        this.name = name;
    }

}
