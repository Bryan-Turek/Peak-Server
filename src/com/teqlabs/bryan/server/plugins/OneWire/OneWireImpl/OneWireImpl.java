package com.teqlabs.bryan.server.plugins.OneWire.OneWireImpl;

import java.util.Map;

import net.xeoh.plugins.base.annotations.PluginImplementation;
import net.xeoh.plugins.base.annotations.events.Init;

import com.teqlabs.bryan.server.plugins.OneWire.OneWire;

/*import com.dalsemi.onewire.*;
import com.dalsemi.onewire.adapter.*;
import com.dalsemi.onewire.container.*;*/

@PluginImplementation
public class OneWireImpl implements OneWire {

	//@SuppressWarnings("static-access")
	@Init
	public void init() {
		/*// TODO Auto-generated method stub
		try {
			DSPortAdapter devices = OneWireAccessProvider.getAdapter("DS9490R", "/dev/bus/usb/002/004");
			
			devices.adapterDetected();
		      devices.targetAllFamilies();
		      devices.beginExclusive(true);
		      devices.reset();
		      devices.setSearchAllDevices();

		      boolean next = devices.findFirstDevice();

		      if (!next)
		      {
		         System.out.println("Could not find any iButtons!");

		         return;
		      }

		      while (next)
		      {
		         OneWireContainer owc = devices.getDeviceContainer();

		         System.out.println(
		            "====================================================");
		         System.out.println("= Found One Wire Device: "
		                            + owc.getAddressAsString() + "          =");
		         System.out.println(
		            "====================================================");
		         System.out.println("=");

		         boolean              isTempContainer = false;
		         TemperatureContainer tc              = null;

		         try
		         {
		            tc              = ( TemperatureContainer ) owc;
		            isTempContainer = true;
		         }
		         catch (Exception e)
		         {
		            tc              = null;
		            isTempContainer = false;   //just to reiterate
		         }

		         if (isTempContainer)
		         {
		            System.out.println("= This device is a " + owc.getName());
		            System.out.println("= Also known as a "
		                               + owc.getAlternateNames());
		            System.out.println("=");
		            System.out.println("= It is a Temperature Container");

		            double  max       = tc.getMaxTemperature();
		            double  min       = tc.getMinTemperature();
		            boolean hasAlarms = tc.hasTemperatureAlarms();

		            System.out.println("= This device " + (hasAlarms ? "has"
		                                                             : "does not have") + " alarms");
		            System.out.println("= Maximum temperature: " + max);
		            System.out.println("= Minimum temperature: " + min);

		            double high  = 0.0;
		            double low   = 0.0;
		            byte[] state = tc.readDevice();

		            if (hasAlarms)
		            {
		               high = tc.getTemperatureAlarm(tc.ALARM_HIGH, state);
		               low  = tc.getTemperatureAlarm(tc.ALARM_LOW, state);

		               System.out.println("= High temperature alarm set to : "
		                                  + high);
		               System.out.println("= Low temperature alarm set to  : " + low);
		            }

		            double  resol      = 0.0;
		            boolean selectable = tc.hasSelectableTemperatureResolution();

		            if (hasAlarms)
		            {
		               resol = tc.getTemperatureAlarmResolution();

		               System.out.println("= Temperature alarm resolution  : "
		                                  + resol);
		            }

		            double   tempres    = tc.getTemperatureResolution(state);
		            double[] resolution = null;

		            System.out.println("= Temperature resolution        : "
		                               + tempres);
		            System.out.println("= Resolution is selectable      : "
		                               + selectable);

		            if (selectable)
		               try
		               {
		                  resolution = tc.getTemperatureResolutions();

		                  for (int i = 0; i < resolution.length; i++)
		                     System.out.println("= Available resolution " + i
		                                        + "        : " + resolution [i]);
		               }
		               catch (Exception e)
		               {
		                  System.out.println(
		                     "= Could not get available resolutions : "
		                     + e.toString());
		               }

		            if (hasAlarms)
		            {
		               System.out.println(
		                  "= Setting high temperature alarm to 28.0 C...");
		               tc.setTemperatureAlarm(tc.ALARM_HIGH, 28.0, state);
		               System.out.println(
		                  "= Setting low temperature alarm to 23.0 C...");
		               tc.setTemperatureAlarm(tc.ALARM_LOW, 23.0, state);
		            }

		            if (selectable)
		               try
		               {
		                  System.out.println("= Setting temperature resolution to "
		                                     + resolution [0] + "...");
		                  tc.setTemperatureResolution(resolution [0], state);
		               }
		               catch (Exception e)
		               {
		                  System.out.println("= Could not set resolution: "
		                                     + e.toString());
		               }

		            try
		            {
		               tc.writeDevice(state);
		               System.out.println("= Device state written.");
		            }
		            catch (Exception e)
		            {
		               System.out.println(
		                  "= Could not write device state, all changes lost.");
		               System.out.println("= Exception occurred: " + e.toString());
		            }

		            System.out.println("= Doing temperature conversion...");

		            try
		            {
		               tc.doTemperatureConvert(state);
		            }
		            catch (Exception e)
		            {
		               System.out.println(
		                  "= Could not complete temperature conversion...");
		            }

		            state = tc.readDevice();

		            if (hasAlarms)
		            {
		               high = tc.getTemperatureAlarm(tc.ALARM_HIGH, state);
		               low  = tc.getTemperatureAlarm(tc.ALARM_LOW, state);

		               System.out.println("= High temperature alarm set to : "
		                                  + high);
		               System.out.println("= Low temperature alarm set to  : " + low);
		            }

		            double temp = tc.getTemperature(state);

		            System.out.println("= Reported temperature: " + temp);
		         }
		         else
		         {
		            System.out.println("= This device is not a temperature device.");
		            System.out.println("=");
		            System.out.println("=");
		         }

		         next = devices.findNextDevice();
		      }
			
		} catch (OneWireIOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (OneWireException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

	@SuppressWarnings("rawtypes")
	@Override
	public String execute(Map o) throws Exception {
		return null;
		
	}
	
}
