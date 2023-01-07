package com.vertxproject1.redisinteg;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.redis.client.*;
import io.vertx.redis.client.impl.RedisClient;

public class MainVerticle extends AbstractVerticle {

  public static void main(String[] args) {
    Redis.createClient(Vertx.vertx())
      .connect()
      .onSuccess(conn -> {
        // use the connection
        System.out.println(conn + " connected");
        conn.send(Request.cmd(Command.SET).arg("key8").arg("value8"));

      });

    RedisAPI redis = RedisAPI.api(Redis.createClient(Vertx.vertx()));
    redis.get("age").onSuccess(value -> {
        // do something...
        System.out.println(value.toString());
      });

  }

//  @Override
//  public void start(Promise<Void> startPromise) throws Exception {
//
//  }
}
