package com.tao.jiang.demo.utils;

import com.mongodb.MongoClient;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Locale;
import java.util.TimeZone;


@Component
public class ConfigurationManager {
    private static ConfigurationManager instance;
    private Log log = LogFactory.getFactory().getInstance(ConfigurationManager.class);

    @Value("${spring.data.mongodb.database}")
    private String databaseName;

    @Value("${spring.data.mongodb.file.database}")
    private String fileDatabaseName;

    @Value("${spring.data.mongodb.host}")
    private String host;

    @Value("${spring.data.mongodb.port}")
    private int port;

    @Value("${token.expiration.period}")
    private int tokenExpirationPeriod;

    @Value("${token.salt}")
    private String tokenSalt;


    private MongoOperations fmwMongoDB;
    private MongoOperations fmwFileMongoDB;

    @PostConstruct
    public void init() {
        Locale.setDefault(Locale.ENGLISH);
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        this.fmwMongoDB = new MongoTemplate(new SimpleMongoDbFactory(new MongoClient(host, port), databaseName));
        this.fmwFileMongoDB = new MongoTemplate(new SimpleMongoDbFactory(new MongoClient(host, port), fileDatabaseName));
        instance = this;
    }

    public static ConfigurationManager getInstance() {
        return instance;
    }

    public static void setInstance(ConfigurationManager instance) {
        ConfigurationManager.instance = instance;
    }

    public Log getLog() {
        return log;
    }

    public void setLog(Log log) {
        this.log = log;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getFileDatabaseName() {
        return fileDatabaseName;
    }

    public void setFileDatabaseName(String fileDatabaseName) {
        this.fileDatabaseName = fileDatabaseName;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getTokenExpirationPeriod() {
        return tokenExpirationPeriod;
    }

    public void setTokenExpirationPeriod(int tokenExpirationPeriod) {
        this.tokenExpirationPeriod = tokenExpirationPeriod;
    }

    public String getTokenSalt() {
        return tokenSalt;
    }

    public void setTokenSalt(String tokenSalt) {
        this.tokenSalt = tokenSalt;
    }

    public MongoOperations getFmwMongoDB() {
        return fmwMongoDB;
    }

    public void setFmwMongoDB(MongoOperations fmwMongoDB) {
        this.fmwMongoDB = fmwMongoDB;
    }

    public MongoOperations getFmwFileMongoDB() {
        return fmwFileMongoDB;
    }

    public void setFmwFileMongoDB(MongoOperations fmwFileMongoDB) {
        this.fmwFileMongoDB = fmwFileMongoDB;
    }
}
