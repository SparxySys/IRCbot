package info.ds003.ircbot.events;

import java.util.ArrayList;
import java.util.List;

import info.ds003.ircbot.Main;

public class WhoisHandler extends Event {

	private boolean waitingWhois = false;
	private List<String> whoisBuffer;
	private String [] resultBuffer;
	
	public WhoisHandler(Main main) {
		super(main);
	}
	
	public String [] getWhoisResult()
	{
		return resultBuffer;
	}

	@Override
	public void handleEvent(String sender, String type, String receiver, String content) 
	{
		if( type.equals("311") ) // Start WHOIS
		{
			waitingWhois = true;
			if( waitingWhois )
				whoisBuffer = new ArrayList<String>();
		}
		else if( type.equals("318") ) // End WHOIS
		{
			if( waitingWhois )
			{
				waitingWhois = false;
				whoisBuffer.add(content);
				int n = whoisBuffer.size();
				resultBuffer = new String[n];
				for( int i = 0; i < n; ++i )
					resultBuffer[i] = whoisBuffer.get(i);
			}
			// Code here for handling the end of the whois command
		}
		else
		{
			if( waitingWhois )
				whoisBuffer.add(content);
		}
	}

}
