package me.tommycake50.sprintspeed.Listeners;

import net.minecraft.server.v1_7_R1.EntityPlayer;

import org.bukkit.craftbukkit.v1_7_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class SprintListener implements Listener{
	float maxSpeed;
	
	public SprintListener(float maxSpeed){
		this.maxSpeed = maxSpeed;
	}

	@EventHandler
	public void onPlayerMoveEvent(PlayerMoveEvent e){
		Player p = e.getPlayer();
		EntityPlayer ep = ((CraftPlayer)p).getHandle();
		if(p.hasPermission("ss.speedsprint")){
			if(p.isSprinting()){
				float ws = ep.abilities.walkSpeed;
				float ns = ws + 0.0001F;                             //If this thing is going to be firing every millisecond I think it's best if we don't go up too fast
				ep.abilities.walkSpeed = (ws >= maxSpeed ? ws : ns);
			}else{
				ep.abilities.walkSpeed = 0.1F;
			}
		}
	}
}
