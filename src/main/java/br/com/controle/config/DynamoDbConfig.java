package br.com.controle.config;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;

import lombok.Data;

@Data
@Configuration
@EnableDynamoDBRepositories(basePackages = ("br.com.controle.repository"))
public class DynamoDbConfig {

  @Value("${aws.dynamodb.endpoint}")
  private String awsEndpoint;

  @Value("${aws.accesskey}")
  private String awsAccessKey;

  @Value("${aws.secretkey}")
  private String awsSecretKey;

  @Value("${aws.region}")
  private String awsRegion;


  public AwsClientBuilder.EndpointConfiguration endpointConfiguration() {
    return new AwsClientBuilder.EndpointConfiguration(awsEndpoint, awsRegion);
  }

  public AWSCredentialsProvider awsCredentialsProvider() {
    return new AWSStaticCredentialsProvider(new BasicAWSCredentials(awsAccessKey, awsSecretKey));
  }

  @Bean
  public DynamoDBMapperConfig dynamoDBMapperConfig() {
    return DynamoDBMapperConfig.DEFAULT;
  }

  @Bean
  public AmazonDynamoDB amazonDynamoDB() {
    return AmazonDynamoDBClientBuilder
        .standard()
        .withEndpointConfiguration(endpointConfiguration())
        .withCredentials(awsCredentialsProvider())
        .build();
  }

  @Bean("forceUpdateDynamoDbTable")
  public String getForceUpdateDynamoDbTable() {

    return "monthly-bills";
  }
}