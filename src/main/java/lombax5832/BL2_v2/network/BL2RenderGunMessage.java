package lombax5832.BL2_v2.network;

import java.util.List;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import lombax5832.BL2_v2.common.item.ItemGun;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;

public class BL2RenderGunMessage implements IMessage{

	private int playerId;
	private int setInUseDuration;
	
	public BL2RenderGunMessage(int playerId, int setInUse){
		this.playerId = playerId;
		this.setInUseDuration = setInUse;
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		playerId = ByteBufUtils.readVarInt(buf, 5);
		setInUseDuration = ByteBufUtils.readVarInt(buf, 5);
	}

	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeVarInt(buf, playerId, 5);
		ByteBufUtils.writeVarInt(buf, setInUseDuration, 5);
	}
	
	public static class Handler implements IMessageHandler<BL2RenderGunMessage, IMessage> {

		@Override
		public IMessage onMessage(BL2RenderGunMessage message, MessageContext ctx) {
			if (message.setInUseDuration>0){
				List list = MinecraftServer.getServer().getConfigurationManager().playerEntityList;
				for(int i=0;i<list.size();i++){
					if(list.get(i) instanceof EntityPlayer){
						EntityPlayerMP player = (EntityPlayerMP) list.get(i);
						
						if(player.getItemInUse()!=null&&player.getItemInUse().getItem() instanceof ItemGun){
							player.setItemInUse(player.getHeldItem(), message.setInUseDuration);
							System.out.println("Render message received");
						}
					}
				}
			}
			return null;
		}
		
	}

}
