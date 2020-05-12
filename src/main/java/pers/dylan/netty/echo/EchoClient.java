package pers.dylan.netty.echo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class EchoClient {
    public static final int SIZE = 0;
    private final String host;
    private final int port;

    public EchoClient(String host, int port) {
        this.port = port;
        this.host = host;
    }

    public static void main(String[] args) {

        if(args.length>0){
            final int port = Integer.parseInt(args[1]);
            final String host = args[0];
            new EchoClient(host, port).run();
        }

    }

    public void run() {
        // TODO 完成client的流程


    }
}