package com.sbezboro.standardgroups.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import com.sbezboro.standardgroups.StandardGroups;
import com.sbezboro.standardgroups.managers.GroupManager;
import com.sbezboro.standardplugin.StandardPlugin;
import com.sbezboro.standardplugin.commands.BaseCommand;
import com.sbezboro.standardplugin.commands.SubCommand;
import com.sbezboro.standardplugin.model.StandardPlayer;

import java.util.ArrayList;
import java.util.List;

public class InviteCommand extends SubCommand {

	public InviteCommand(StandardPlugin plugin, BaseCommand command) {
		super(plugin, command, "invite", new ArrayList<String>() {{
			add("inv");
		}});

		addHelp(ChatColor.YELLOW + "/g invite <player>" + ChatColor.RESET + " - invite a player to your group");
	}

	@Override
	public boolean handle(CommandSender sender, String[] args) {
		if (args.length != 1) {
			sender.sendMessage("You must specify a player to invite.");
			return false;
		}
		
		StandardPlayer player = plugin.getStandardPlayer(sender);
		
		GroupManager groupManager = StandardGroups.getPlugin().getGroupManager();
		groupManager.invitePlayer(player, args[0]);
		
		return true;
	}

}
