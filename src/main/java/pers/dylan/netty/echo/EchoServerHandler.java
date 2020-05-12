package pers.dylan.netty.echo;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

public class EchoServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf in = (ByteBuf)msg;
        try {
        while (in.isReadable()){
//           ctx.write(msg);
           //netty在消息写出会自动释放
//           ctx.flush();
            ctx.writeAndFlush(msg);
        }
        } finally {
//            ((ByteBuf)msg).release();
            ReferenceCountUtil.release(msg);
        }

        // 或者直接打印
        System.out.println("Yes, A new client in = " + ctx.name());


    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
