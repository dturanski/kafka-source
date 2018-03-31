FROM projectriff/java-function-invoker:0.0.6-snapshot
ARG FUNCTION_JAR=/functions/kafka-source-0.0.1-SNAPSHOT.jar
ARG FUNCTION_HANDLER=io.projectriff.samples.kafka.KafkaSourceFunction&main=io.projectriff.samples.kafka.KafkaSourceApplication
ADD target/kafka-source-0.0.1-SNAPSHOT.jar $FUNCTION_JAR
ENV FUNCTION_URI file://${FUNCTION_JAR}?handler=${FUNCTION_HANDLER}
