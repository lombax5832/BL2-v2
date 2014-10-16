package lombax5832.BL2_v2.network;

import io.netty.buffer.ByteBuf;

import java.util.List;

import lombax5832.BL2_v2.common.item.ItemGun;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class BL2Message implements IMessage{

	private int reload;
	
	private int playerId;
	
	public BL2Message(){};
	
	public BL2Message(int reload, int playerId){
		this.reload = reload;
		this.playerId = playerId;
	}
	
	
	
	@Override
	public void fromBytes(ByteBuf buf) {
		reload = ByteBufUtils.readVarInt(buf, 5);
		playerId = ByteBufUtils.readVarInt(buf, 5);
	}

	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeVarInt(buf, reload, 5);	
		ByteBufUtils.writeVarInt(buf, playerId, 5);	
	}
	
	public static class Handler implements IMessageHandler<BL2Message, IMessage> {

		@Override
		public IMessage onMessage(BL2Message message, MessageContext ctx) {
			if (message.reload==1){
				List list = MinecraftServer.getServer().getConfigurationManager().playerEntityList;
				for(int i=0;i<list.size();i++){
					if(list.get(i) instanceof EntityPlayer){
						EntityPlayerMP player = (EntityPlayerMP) list.get(i);
						if(player.getEntityId()==message.playerId){
							System.out.println(player.getDisplayName()+" hit reload");
							if(player.getItemInUse()!=null&&player.getItemInUse().getItem() instanceof ItemGun){
								ItemStack stack = player.getItemInUse();
								ItemGun.reload(stack);
							}
						}
					}
				}
			}
			return null;
		}
		
	}

}
