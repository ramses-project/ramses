#!/usr/bin/php

<?php

################################# NAMING #######################################

$root=dirname(__FILE__) ;

$settings_file_path=$root . '/build_and_test/fr.tpt.aadl.ramses.build.main/settings.xml' ;
$settings_qualifier='-SNAPSHOT';
$ramses_node='ramses-version';

$manifest_file_name='MANIFEST.MF';
$manifest_directive='Bundle-Version: ' ;
$manifest_qualifier='.qualifier';

$feature_file_path=$root . '/build_and_test/fr.tpt.aadl.ramses.build.feature/feature.xml';
$feature_qualifier=$manifest_qualifier ;
$update_site_file_path=$root . '/../update-site/site.xml';
$url_root='features/fr.tpt.aadl.ramses.feature_';

$log='* all:' . PHP_EOL . '  - Update version number.' ;

$version_file_path=$root . '/build_and_test/fr.tpt.aadl.ramses.build.main/version' ;

################################### MAIN #######################################

// Arguments verification:

if(count($argv) != 2)
{
  print('Wrong version number. Version number has to be quoted !' . PHP_EOL);
  print("example: '1.0.0'" . PHP_EOL);
  print("Don't put 'qualifier' or 'SNAPSHOT' at the end of the version number. It will be automaticaly added" . PHP_EOL);
  print('abort' . PHP_EOL);
  exit(-1);
}

print('Proceed with the version number: ' . $argv[1] . PHP_EOL) ;

// Update the RAMSES version number for maven build settings.
$settings_version=$argv[1] . $settings_qualifier ;
updateMavenSettings($settings_version);

// Update manifest files.
$manifest_files=rsearch($root, "/$manifest_file_name/") ;
$directive_pattern='/' . $manifest_directive . '.*/';
$new_directive=$manifest_directive . $argv[1] . $manifest_qualifier ;

foreach($manifest_files as $file)
{
  replace($file, $directive_pattern, $new_directive);
}

// Update the RAMSES features (Eclipse update site).
$feature_version=$argv[1] . $feature_qualifier ;
updateRamsesFeature($feature_file_path, $feature_version);
updateSite($update_site_file_path, $feature_version, $url_root);

// Update version file.
updateVersionFile($version_file_path, $argv[1]) ;

// Update repository.
print('Every files are updated, proceed GIT commit (y/n) ?' . PHP_EOL);

$answer=readStdin() ;
$answer=str_replace(PHP_EOL, '', $answer);

if(strcasecmp($answer,'y') == 0 or
   strcasecmp($answer,'yes') == 0)
{
  callGIT($log);
  print ('*** UPDATE DONE ***' . PHP_EOL);
}
else
{
  print('*** UPDATE DONE WITHOUT COMMIT ***' . PHP_EOL);
}

exit(0) ;

################################## FUNCTIONS ###################################

function updateMavenSettings($version)
{
  $settings=simplexml_load_file($GLOBALS['settings_file_path']) ;
  $settings->profiles->profile->properties->$GLOBALS['ramses_node']=$version;
  $settings->asXML($GLOBALS['settings_file_path']);
  print($GLOBALS['settings_file_path'] . ' has been modifed' . PHP_EOL);
}

function updateSite($file, $version, $url_root)
{
  $config=simplexml_load_file($file);
  $config->feature['version']=$version ;
  $config->feature['url']=$url_root . $version . '.jar' ;
  $config->asXML($file);
  print($file . ' has been modifed' . PHP_EOL);
}

function updateRamsesFeature($file, $version)
{
  $features=simplexml_load_file($file);
  $features['version']=$version ;
  $features->asXML($file);
  print($file . ' has been modifed' . PHP_EOL);
}

function rsearch($folder, $pattern)
{
  $dir = new RecursiveDirectoryIterator($folder);
  $ite = new RecursiveIteratorIterator($dir);
  $files = new RegexIterator($ite, $pattern, RegexIterator::GET_MATCH);
  $fileList = array();
  foreach($files as $file)
  {
    $fileList[]=$files->key() ;
  }
  return $fileList;
}

function replace($file, $pattern, $value)
{
  $file_content=file_get_contents($file);
  $file_content=preg_replace($pattern, $value, $file_content) ;
  file_put_contents($file, $file_content);
  print($file . ' has been modifed' . PHP_EOL);
}

function updateVersionFile($file, $version)
{
  // Delete old file
  unlink($file);
  
  // Create a new file with the given version number
  file_put_contents($file, $version);
  print($file . ' has been modifed' . PHP_EOL);
}

function callGIT($log)
{
  print('NOT IMPLEMENTED YET' . PHP_EOL);
}

function readStdin()
{
  $stdin=fopen("php://stdin", "r");
  $data=fgets($stdin);
  fclose($stdin);
  return $data ;
}

############################## INFORMATIONS ####################################
//-----------------------------------------------------------------------------
// settings.xml
/*
  <profiles>
    <profile>  
      <id>common</id>
      <properties>
        <ramses-version>1.0.0-SNAPSHOT</ramses-version>
        <osate-version>2.0.0-SNAPSHOT</osate-version>
      </properties>
    </profile>
  </profiles>
*/
//-----------------------------------------------------------------------------
// MANIFEST.MF
// Bundle-Version: 1.0.0.qualifier
//-----------------------------------------------------------------------------
// site.xml
/*
<site>
   <description url="http://aadl.telecom-paristech.fr/">
      TELECOM ParisTech AADL corner.
   </description>
   <feature url="features/fr.tpt.aadl.ramses.feature_1.0.1.qualifier.jar" id="fr.tpt.aadl.ramses.feature" version="1.0.1.qualifier">
      <category name="ramses_category"/>
   </feature>
   <category-def name="ramses_category" label="AADL-RAMSES">
      <description>
         RAMSES (Refinement of AADL Models for Synthesis of Embedded Systems) is a model transformation and code generation tool that produces C code for ARINC653-compliant operating systems and OSEK-compliant operating systems.
      </description>
   </category-def>
</site>
*/
//-----------------------------------------------------------------------------
// feature.xml
/*
<feature id="fr.tpt.aadl.ramses.feature" label="AADL-RAMSES-Feature" version="1.0.1.qualifier" provider-name="TELECOM ParisTech">
*/
?>
