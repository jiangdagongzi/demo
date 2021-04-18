package com.tao.jiang.demo.scheduler.workers.db;

import com.tao.jiang.demo.entity.Token;
import com.tao.jiang.demo.repository.token.TokenRepository;
import com.tao.jiang.demo.scheduler.workers.AbstractDaemonWorker;
import com.tao.jiang.demo.utils.ConfigurationManager;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

import java.util.Date;
import java.util.List;

public class TokenRefresher extends AbstractDaemonWorker {
    private Log log = LogFactory.getFactory().getInstance(TokenRefresher.class);
    private TokenRepository tokenRepository = ConfigurationManager.getInstance().getTokenRepository();

    @Override
    protected void execute() throws Exception {
        try{
            List<Token> tokens = tokenRepository.findAll();
            for(Token token : tokens){
                if(canBeReMoved(token)){
                    tokenRepository.delete(token);
                }
            }
        }catch (Exception e){

        }
    }

    private boolean canBeReMoved(Token token) {
        return new Date().getTime() - token.getCreateTime().getTime() > 43100;
    }
}
