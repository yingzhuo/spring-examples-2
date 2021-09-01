package spring.examples.graphql.exceptionhandler;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.schema.DataFetchingEnvironment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.execution.DataFetcherExceptionResolver;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;

@Slf4j
@Component
class ExceptionHandlers implements DataFetcherExceptionResolver {

    @Override
    public Mono<List<GraphQLError>> resolveException(Throwable exception, final DataFetchingEnvironment env) {
        if (exception instanceof UnsupportedOperationException) {
            return Mono.fromCallable(() -> Collections.singletonList(
                    GraphqlErrorBuilder.newError(env)
                            .errorType(ErrorType.DataFetchingException)
                            .message(exception.getMessage())
                            .build()
            ));
        }
        return Mono.empty();
    }

}
