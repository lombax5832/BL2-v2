package lombax5832.BL2_v2.network;

import io.netty.buffer.ByteBuf;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class BL2Message implements IMessage{

	private String text;
	
	public BL2Message(){};
	
	public BL2Message(String text){
		this.text = text;
	}
	
	
	
	@Override
	public void fromBytes(ByteBuf buf) {
		text = ByteBufUtils.readUTF8String(buf);
	}

	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeUTF8String(buf, text);		
	}
	
	public static class Handler implements IMessageHandler<BL2Message, IMessage> {

		@Override
		public IMessage onMessage(BL2Message message, MessageContext ctx) {
			
			return null;
		}
		
	}

}
