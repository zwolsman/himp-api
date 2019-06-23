package com.zwolsman.himpapi.config

import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.influxdb.InfluxDBConnectionFactory
import org.springframework.data.influxdb.InfluxDBProperties
import org.springframework.data.influxdb.InfluxDBTemplate
import org.springframework.data.influxdb.converter.PointConverter

@Configuration
@EnableConfigurationProperties(InfluxDBProperties::class)
class InfluxDBConfiguration {

    @Bean
    fun connectionFactory(properties: InfluxDBProperties) = InfluxDBConnectionFactory(properties)

    @Bean
    fun influxDBTemplate(connectionFactory: InfluxDBConnectionFactory) = InfluxDBTemplate(connectionFactory, PointConverter())
}