package com.tao.jiang.demo.scheduler.workers.db;

import com.tao.jiang.demo.entity.Token;
import com.tao.jiang.demo.repository.mongoRepository.token.TokenMongoRepository;
import com.tao.jiang.demo.scheduler.workers.AbstractDaemonWorker;
import com.tao.jiang.demo.utils.ConfigurationManager;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

import java.util.Date;
import java.util.List;

public class TokenRefresher extends AbstractDaemonWorker {
    private Log log = LogFactory.getFactory().getInstance(TokenRefresher.class);
    private TokenMongoRepository tokenMongoRepository = ConfigurationManager.getInstance().getTokenMongoRepository();

    @Override
    protected void execute() throws Exception {
        try {
            List<Token> tokens = tokenMongoRepository.findAll();
            for (Token token : tokens) {
                if (canBeReMoved(token)) {
                    tokenMongoRepository.delete(token);
                }
            }
        } catch (Exception e) {

        }
    }

    private boolean canBeReMoved(Token token) {
        return new Date().getTime() - token.getCreateTime().getTime() > 43100;
    }
}
