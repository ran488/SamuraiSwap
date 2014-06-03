package com.samuraiswap;

import java.util.Properties;

import org.apache.log4j.Logger;

import com.samuraiswap.dto.SwapItem;

public class TempDebugCrap {

	private static final Logger log = Logger.getLogger(TempDebugCrap.class);

	Properties sysProps;

	public TempDebugCrap() {
		String[] envVars = System.getenv().toString().split(",");
		for (String var : envVars) {
			log.debug(var);
		}
	}

	public void setProps(Properties props) {
		this.sysProps = props;
		log.info(props.toString());
	}
}
