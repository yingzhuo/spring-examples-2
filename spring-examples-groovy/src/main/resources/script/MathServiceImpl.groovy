package script

import spring.examples.groovy.service.MathService

class MathServiceImpl implements MathService {

    @Override
    int add(int x, int y) {
        return x + y
    }

}