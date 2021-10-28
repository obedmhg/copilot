
import java.util.*;
import java.io.*;
import java.util.Scanner;
import java.util.Random;
// import apache poi
import org.apache.poi.*;
// import kafka
import org.apache.kafka.*;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.clients.consumer.*;

public class SomeJava {
    // create main method
    public static void main(String[] args) {
        // print out hello world
        System.out.println("Hello World");
    }

    // orderList items
    public static void orderList(List<String> items) {
        // sort items
        Collections.sort(items);
        // print out items
        for (String item : items) {
            System.out.println(item);
        }
    }

    // ask for input from the user
    public static String askForInput() {
        // create scanner
        Scanner scanner = new Scanner(System.in);
        // ask for input
        System.out.println("Enter a number: ");
        // return input
        return scanner.nextLine();
    }

    // work with apache poi
    public static void workWithApachePoi() {
        // create workbook
        Workbook workbook = new XSSFWorkbook();
        // create sheet
        Sheet sheet = workbook.createSheet("Sheet1");
        // create row
        Row row = sheet.createRow(0);
        // create cell
        Cell cell = row.createCell(0);
        // set cell value
        cell.setCellValue("Hello World");
        // write workbook
        try {
            FileOutputStream outputStream = new FileOutputStream("workbook.xlsx");
            workbook.write(outputStream);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // work with apache spark
    public static void workWithApacheSpark() {
        // create spark context
        SparkContext sparkContext = new SparkContext("local", "Java Spark");
        // create rdd
        JavaRDD<String> rdd = sparkContext.textFile("data.txt");
        // print rdd
        rdd.foreach(System.out::println);
    }

    // work with kafka
    public static void workWithKafka() {
        // create kafka producer
        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(
            ImmutableMap.of(
                "bootstrap.servers", "localhost:9092",
                "key.serializer", "org.apache.kafka.common.serialization.StringSerializer",
                "value.serializer", "org.apache.kafka.common.serialization.StringSerializer"
            )
        );
        // create kafka consumer
        KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<>(
            ImmutableMap.of(
                "bootstrap.servers", "localhost:9092",
                "key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer",
                "value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer"
            )
        );
        // create kafka producer record
        ProducerRecord<String, String> producerRecord = new ProducerRecord<>("topic", "key", "value");
        // send record
        kafkaProducer.send(producerRecord);
        // create kafka consumer record
        ConsumerRecord<String, String> consumerRecord = new ConsumerRecord<>("topic", 0, 0, "key", "value");
        // print record
        System.out.println(consumerRecord);
    }

    // work with rabbitMQ
    public static void workWithRabbitMQ() {
        // create rabbitmq connection factory
        ConnectionFactory connectionFactory = new ConnectionFactory();
        // set host
        connectionFactory.setHost("localhost");
        // create connection
        Connection connection = connectionFactory.newConnection();
        // create channel
        Channel channel = connection.createChannel();
        // create exchange
        channel.exchangeDeclare("exchange", "direct");
        // create queue
        channel.queueDeclare("queue", false, false, false, null);
        // create message
        String message = "Hello World";
        // create properties
        AMQP.BasicProperties properties = new AMQP.BasicProperties.Builder()
            .contentType("text/plain")
            .deliveryMode(2)
            .build();
        // publish message
        channel.basicPublish("exchange", "queue", properties, message.getBytes());
        // close channel
        channel.close();
        // close connection
        connection.close();
    }

    // work with graphql
    public static void workWithGraphql() {
        // create graphql schema
        GraphQLSchema schema = GraphQLSchema.newSchema()
            .query(
                newObject()
                    .name("Query")
                    .field(newFieldDefinition()
                        .name("hello")
                        .type(GraphQLString)
                        .dataFetcher(environment -> "Hello World")
                    )
                    .build()
            )
            .build();
        // create graphql executor
        GraphQL graphql = GraphQL.newGraphQL(schema).build();
        // create graphql execution environment
        ExecutionEnvironment executionEnvironment = ExecutionEnvironment.newExecutionEnvironment()
            .query("{ hello }")
            .build();
        // execute graphql
        ExecutionResult executionResult = graphql.execute(executionEnvironment);
        // print result
        System.out.println(executionResult.getData().toString());
    }

    // call an api
    public static String callApi() {
        // create url
        String url = "https://api.github.com/users/javainuse";
        // create request
        Request request = new Request.Builder()
                .url(url)
                .build();
        // create client
        OkHttpClient client = new OkHttpClient();
        // create response
        Response response = null;
        // try to get response
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // return response
        return response.body().toString();
    }

    // get user by id
    public static String getUserById(String id) {
        // create url
        String url = "https://api.github.com/users/" + id;
        // create request
        Request request = new Request.Builder()
                .url(url)
                .build();
        // create client
        OkHttpClient client = new OkHttpClient();
        // create response
        Response response = null;
        // try to get response
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // return response
        return response.body().toString();
    }
    
    // connect to coherence
    public static void connectToCoherence() {
        // create cache configuration
        CacheConfiguration<String, String> cacheConfiguration = new CacheConfiguration<>("cache");
        // create cache manager
        CacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder()
            .withCache("cache", cacheConfiguration)
            .build(true);
        // create cache
        Cache<String, String> cache = cacheManager.getCache("cache", String.class, String.class);
        // put value
        cache.put("key", "value");
        // get value
        String value = cache.get("key");
        // print value
        System.out.println(value);
    }

    // query coherence
    public static void queryCoherence() {
        // create cache configuration
        CacheConfiguration<String, String> cacheConfiguration = new CacheConfiguration<>("cache");
        // create cache manager
        CacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder()
            .withCache("cache", cacheConfiguration)
            .build(true);
        // create cache
        Cache<String, String> cache = cacheManager.getCache("cache", String.class, String.class);
        // create query
        Query query = new QueryBuilder()
            .addCriteria(new Criteria("key").is("value"))
            .build();
        // query cache
        QueryResult<Map.Entry<String, String>> queryResult = cache.query(query);
        // print result
        System.out.println(queryResult.getResult().get(0).getValue());
    }

    // purchase with paypal
    public static void purchaseWithPaypal() {
        // create paypal client
        PayPalHttpClient paypalHttpClient = new PayPalHttpClient(
            new SandboxEnvironment(
                "Acme Corp",
                "AcmeCorp_SB_clientId",
                "AcmeCorp_SB_secret",
                "AcmeCorp_SB_username",
                "AcmeCorp_SB_password"
            )
        );
        // create paypal payment
        Payment payment = new Payment();
        // set amount
        payment.setAmount(new Amount(new Currency("USD"), "100"));
        // set intent
        payment.setIntent("sale");
        // set payer
        Payer payer = new Payer();
        payer.setPaymentMethod("paypal");
        payment.setPayer(payer);
        // set redirect urls
        RedirectUrls redirectUrls = new RedirectUrls();
        redirectUrls.setCancelUrl("http://localhost:8080/cancel");
        redirectUrls.setReturnUrl("http://localhost:8080/success");
        payment.setRedirectUrls(redirectUrls);
        // create paypal payment request
        PaymentRequest paymentRequest = new PaymentRequest();
        paymentRequest.setPayment(payment);
        // create paypal payment response
        PaymentResponse paymentResponse = paypalHttpClient.execute(paymentRequest);
        // print response
        System.out.println(paymentResponse.getLinks().get(0).getHref());
    }

}