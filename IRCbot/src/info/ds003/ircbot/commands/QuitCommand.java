package info.ds003.ircbot.commands;

import info.ds003.ircbot.Main;

public class QuitCommand extends Command {

	public QuitCommand(String name, boolean requiresAdmin, Main main) 
	{
		super(name, requiresAdmin, main);
	}
	
	public QuitCommand(String name, String description, boolean requiresAdmin, Main main)
	{
		super(name, description, requiresAdmin, main);
	}

	@Override
	protected void runCommand(String content) 
	{
		actionCenter.quit("bubais");
	}

}