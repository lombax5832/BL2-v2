package lombax5832.BL2_v2.network;

import io.netty.buffer.ByteBuf;

import java.util.List;

import lombax5832.BL2_v2.common.entity.EntityBullet;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class BL2FireGunMessage implements IMessage{

	private int playerId;
	
	public BL2FireGunMessage(){};
	
	public BL2FireGunMessage(int playerId){
		this.playerId = playerId;
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		playerId = ByteBufUtils.readVarInt(buf, 5);
	}

	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeVarInt(buf, playerId, 5);
	}
	
	public static class Handler implements IMessageHandler<BL2FireGunMessage, IMessage>{

		@Override
		public IMessage onMessage(BL2FireGunMessage message, MessageContext ctx) {
			List list = MinecraftServer.getServer().getConfigurationManager().playerEntityList;
			for(int i=0;i<list.size();i++){
				if(list.get(i) instanceof EntityPlayer){
					EntityPlayerMP player = (EntityPlayerMP) list.get(i);
					if(player.getEntityId()==message.playerId){
//						System.out.println("message received");
						player.worldObj.spawnEntityInWorld(new EntityBullet(player.worldObj,player));
						break;
					}
				}
			}
			return null;
		}
	}
}
