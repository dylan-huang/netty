package pers.dylan.netty.discard;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.ReferenceCounted;

public class DiscardServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf in = (ByteBuf)msg;
        try {
        while (in.isReadable()){
            System.out.println(in.readByte());
            System.out.flush();
        }
        } finally {
//            ((ByteBuf)msg).release();
            ReferenceCountUtil.release(msg);
        }

        // 或者直接打印
        System.out.println("Yes, A new client in = " + ctx.name());


    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
