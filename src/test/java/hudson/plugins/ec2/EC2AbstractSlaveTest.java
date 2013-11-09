package hudson.plugins.ec2;


import hudson.slaves.NodeProperty;
import org.jvnet.hudson.test.HudsonTestCase;

import java.util.ArrayList;

public class EC2AbstractSlaveTest extends HudsonTestCase{

    int timeoutInSecs = Integer.MAX_VALUE;
    public void testGetLaunchTimeoutInMillisShouldNotOverflow() throws Exception {
        EC2AbstractSlave slave = new EC2AbstractSlave("name","id","description","fs",22,1,null,"label",null,null,"init", new ArrayList<NodeProperty<?>>(),"remote","root","jvm",false,"idle",null,"cloud",false,Integer.MAX_VALUE, false, "" , false) {
            @Override
            public void terminate() {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public String getEc2Type() {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }
        };


        assertEquals((long)timeoutInSecs * 1000, slave.getLaunchTimeoutInMillis());
    }
}
