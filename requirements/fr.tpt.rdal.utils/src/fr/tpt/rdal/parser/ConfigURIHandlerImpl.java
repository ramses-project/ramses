package fr.tpt.rdal.parser;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.xmi.impl.URIHandlerImpl;

public class ConfigURIHandlerImpl extends URIHandlerImpl {

    private final Map<String, String> relativeUrisMap;
    
    public ConfigURIHandlerImpl(     final String p_configDir,
                                    final String p_pluginDir ,
                                    final String p_workspaceDir ) {
        relativeUrisMap = new HashMap<String, String>();
        relativeUrisMap.put( "../../config/", p_configDir );
        relativeUrisMap.put( "../../plugin/", p_pluginDir );
        relativeUrisMap.put( "../../resource/", p_workspaceDir );
    }
   
    @Override
    public URI resolve( final URI p_uri ) {
        if ( p_uri.isRelative() && p_uri.isHierarchical() ) {
            final String uriPath = p_uri.path();
           
            if ( uriPath != null ) {
                for ( final Map.Entry<String, String> entry : relativeUrisMap.entrySet() ) {
                    final String prefix = entry.getKey();

                    if ( uriPath.startsWith( prefix ) ) {
                        return createAbsURI( p_uri, prefix, entry.getValue() );
                    }
                }
            }
        }

        return super.resolve( p_uri );
    }
   
    private URI createAbsURI(     final URI p_uri,
                                final String p_relUriPrefix,
                                final String p_absUriPrefix ) {
        if ( p_absUriPrefix == null ) {
            throw new IllegalArgumentException( "Directory for " + p_relUriPrefix + " is needed in URI " + p_uri + " and must be defined in program arguments." );
        }
       
        URI resUri = URI.createFileURI( p_uri.path().replaceFirst( p_relUriPrefix, p_absUriPrefix ) );
        resUri = resUri.appendFragment( p_uri.fragment() );
//        logger.debug( "Replacing " + p_uri + " with " + resUri );

        return resUri;

    }
}
