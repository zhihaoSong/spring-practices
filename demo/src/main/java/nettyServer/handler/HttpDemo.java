package nettyServer.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import nettyServer.HttpNettyServer.HttpMessageHandler;

/**
 * Created by wentian on 16/6/1.
 */
public class HttpDemo extends HttpMessageHandler {
    @Override
    public void handle(ChannelHandlerContext ctx, FullHttpRequest request, FullHttpResponse response) {
        response.content().writeBytes("hello".getBytes());
    }
}
