package com.checklist.scripts;

import oracle.adf.scripts.ADFBaseScript;

import com.checklist.flows.SearchFlow;

public class SearchScript extends ADFBaseScript{
	public void scriptMain() {
		try{
			SearchFlow flow = new SearchFlow();
			flow.run(dataMap);
		}
		catch (Exception e)
		{
			logger.error(e.getCause());
		}
		
	}

}
