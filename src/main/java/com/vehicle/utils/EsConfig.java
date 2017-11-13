package com.vehicle.utils;

import java.net.InetAddress;
import java.net.InetSocketAddress;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import com.vehicle.dao.VehicleRepoElasticSearch;

@Configuration
@EnableElasticsearchRepositories(basePackageClasses = VehicleRepoElasticSearch.class)
@ComponentScan(basePackages = { "com.vehicle.service" })
public class EsConfig {

    @Value("${elasticsearch.host}")
    private String EsHost;

    @Value("${elasticsearch.port}")
    private int EsPort;

    @Value("${elasticsearch.clustername}")
    private String EsClusterName;
    
    @Value("${elasticsearch.home:/usr/local/Cellar/elasticsearch/2.3.2}")
    private String elasticsearchHome;


    @Bean
    public Client client() throws Exception {

        Settings esSettings = Settings.builder()
                .build();

        //https://www.elastic.co/guide/en/elasticsearch/guide/current/_transport_client_versus_node_client.html
        return TransportClient.builder()
                .settings(esSettings)
                .build()
                .addTransportAddress(
				  new InetSocketTransportAddress(new InetSocketAddress("127.0.0.1", 9300)));
    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() throws Exception {
        return new ElasticsearchTemplate(client());
    }
}
