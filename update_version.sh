#!/usr/bin/php

<?php

/**
 * AADL-RAMSES
 * 
 * Copyright © 2014 TELECOM ParisTech and CNRS
 * 
 * TELECOM ParisTech/LTCI
 * 
 * Authors: see AUTHORS
 * 
 * This program is free software: you can redistribute it and/or modify 
 * it under the terms of the Eclipse Public License as published by Eclipse,
 * either version 1.0 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Eclipse Public License for more details.
 * You should have received a copy of the Eclipse Public License
 * along with this program.  If not, see 
 * http://www.eclipse.org/org/documents/epl-v10.php
 */

################################# NAMING #######################################

$root=dirname(__FILE__) ;

$pom_file_name='pom.xml' ;
$pom_qualifier='-SNAPSHOT';
$build_pom_file_path=$root . '/build_and_test/fr.tpt.aadl.ramses.build.main/' . $pom_file_name ;


$manifest_file_name='MANIFEST.MF';
$manifest_directive='Bundle-Version: ' ;
$manifest_qualifier='.qualifier';

$feature_file_path=$root . '/build_and_test/fr.tpt.aadl.ramses.build.feature/feature.xml';
$feature_qualifier=$manifest_qualifier ;
$update_site_file_path=$root . '/build_and_test/fr.tpt.aadl.ramses.build.update.site/site.xml';
$url_root='features/fr.tpt.aadl.ramses.feature_';

$log='* all:' . PHP_EOL . '  - Update version number.' ;

$version_file_path=$root . '/build_and_test/fr.tpt.aadl.ramses.build.main/version' ;

################################### MAIN #######################################

// Arguments verification:

if(count($argv) != 2)
{
  print('Unexpected or missing version number. Remember: version number has to be quoted !' . PHP_EOL);
  print("example: '1.0.0'" . PHP_EOL);
  print('abort' . PHP_EOL);
  exit(-1);
}

print("Don't put 'qualifier' or 'SNAPSHOT' at the end of the version number. It will be automaticaly added" . PHP_EOL);
print('Proceed with the version number: ' . $argv[1] . ' (y/n) ?' . PHP_EOL) ;
if(confirm() == False)
{
  print('abort' . PHP_EOL);
  exit(0) ;
}

// Update the RAMSES version number for maven build.
$pom_version=$argv[1] . $pom_qualifier ;

// Update the ramses.build.main pom.xml.
updateBuildPom($build_pom_file_path, $pom_version);

// Backup ramses.build.main pom.xml.
$build_pom_content=file_get_contents($build_pom_file_path);

// Update all pom.xml including ramses.build.main pom.xml (yes dump treatment).
$pom_files=rsearch($root, "/$pom_file_name/");
foreach($pom_files as $file)
{
  updatePom($file, $pom_version);
}

// Revert ramses.build.main pom.xml.
file_put_contents($build_pom_file_path, $build_pom_content);

// Update manifest files.
$manifest_files=rsearch($root, "/$manifest_file_name/") ;
$directive_pattern='/' . $manifest_directive . '.*/';
$new_directive=$manifest_directive . $argv[1] . $manifest_qualifier ;

foreach($manifest_files as $file)
{
  updateManifest($file, $directive_pattern, $new_directive);
}

// Update the RAMSES update site).
$feature_version=$argv[1] . $feature_qualifier ;
updateRamsesFeature($feature_file_path, $feature_version);
updateSite($update_site_file_path, $feature_version, $url_root);

// Update version file.
updateVersionFile($version_file_path, $argv[1]) ;

// Update repository.
print('Every files are updated, proceed GIT commit (y/n) ?' . PHP_EOL);

if(confirm() == True)
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

function confirm()
{
  $answer=readStdin() ;
  $answer=str_replace(PHP_EOL, '', $answer);

  if(strcasecmp($answer,'y') == 0 or
     strcasecmp($answer,'yes') == 0)
  {
    return True ;
  }
  else
  {
    return False ;
  }
}

function updatePom($file, $version)
{
  $pom=simplexml_load_file($file) ;
  $pom->parent->version=$version;
  $pom->asXML($file);
  print($file . ' has been modifed' . PHP_EOL);
}

function updateBuildPom($file, $version)
{
  $pom=simplexml_load_file($file) ;
  $pom->version=$version;
  $pom->asXML($file);
  print($file . ' has been modifed' . PHP_EOL);
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

function updateManifest($file, $pattern, $value)
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
// pom.xml
/*
	<parent>
    <groupId>ramses</groupId>
    <artifactId>fr.tpt.aadl.ramses.build.main</artifactId>
    <version>1.0.0-SNAPSHOT</version>
    <relativePath>../../build_and_test/fr.tpt.aadl.ramses.build.main/pom.xml</relativePath>
  </parent>
*/
//-----------------------------------------------------------------------------
// ramses.build.main pom.xml
/*
  <modelVersion>4.0.0</modelVersion>
  <groupId>ramses</groupId>
  <artifactId>fr.tpt.aadl.ramses.build.main</artifactId>
  <version>1.0.1-SNAPSHOT</version>
  <packaging>pom</packaging>
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
