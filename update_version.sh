#!/usr/bin/php

<?php

################################# NAMING #######################################

$root=dirname(__FILE__) ;
$settings_file_name=$root . '/build_and_test/fr.tpt.aadl.ramses.build.main/settings.xml' ;
$manifest_file_name='MANIFEST.MF';
$ramses_node='ramses-version';
$manifest_directive='Bundle-Version: ' ;
$log='* all:' . PHP_EOL . '  - Update version number.' ;
     

################################### MAIN #######################################

// Arguments verification:

if(count($argv) != 2)
{
  print('Wrong version number. Version number has to be quoted !' . PHP_EOL);
  print('abort' . PHP_EOL);
  exit(-1);
}

print('Proceed with the version number: ' . $argv[1] . PHP_EOL) ;



// update the RAMSES version number for maven build settings.
updateMavenSettings();

$manifest_files=rsearch($root, "/$manifest_file_name/") ;

$directive_pattern='/' . $manifest_directive . '.*/';
$new_directive=$manifest_directive . $argv[1];

foreach($manifest_files as $file)
{
  replace($file, $directive_pattern, $new_directive);
}

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

function updateMavenSettings()
{
  $settings=simplexml_load_file($GLOBALS['settings_file_name']) ;
  $settings->profiles->profile->properties->$GLOBALS['ramses_node']='coucou' ;
  $settings->asXML($GLOBALS['settings_file_name']);
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

// update the version number in the VERSION file.

// CALL SVN from the aadlmt root.

//-----------------------------------------------------------------------------
// settings
// sed: yes on '1.0.0.qualifier' for node 'ramses-version'

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
// sed: yes on '1.0.0.qualifier'

// Bundle-Version: 1.0.0.qualifier
?>
