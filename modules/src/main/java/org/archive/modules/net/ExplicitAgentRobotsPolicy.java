package org.archive.modules.net;

import org.archive.modules.CrawlURI;

public class ExplicitAgentRobotsPolicy extends RobotsPolicy {

    public static RobotsPolicy INSTANCE = new ExplicitAgentRobotsPolicy();

    public ExplicitAgentRobotsPolicy(){}

    /** whether to obey the 'nofollow' directive in an HTML META ROBOTS element */
    protected boolean obeyMetaRobotsNofollow = true;
    public boolean isObeyMetaRobotsNofollow() {
        return obeyMetaRobotsNofollow;
    }
    public void setObeyMetaRobotsNofollow(boolean obeyMetaRobotsNofollow) {
        this.obeyMetaRobotsNofollow = obeyMetaRobotsNofollow;
    }


    @Override
    public boolean allows(String userAgent, CrawlURI curi, Robotstxt robotstxt) {
        RobotsDirectives directives = robotstxt.getDirectivesFor(userAgent, false);
        if(directives!=null){
            return directives.allows(getPathQuery(curi));
        }
        return true;
    }

    @Override
    public boolean obeyMetaRobotsNofollow() {
        return obeyMetaRobotsNofollow;
    }
}
