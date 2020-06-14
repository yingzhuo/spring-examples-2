package spring.examples.scanning.x;

import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import({
        EnableScanningConfiguration.class
})
public @interface EnableScanning {

    public String[] basePackages() default {};

}
