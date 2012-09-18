<?xml version = '1.0' encoding = 'ISO-8859-1' ?>
<asm version="1.0" name="0">
	<cp>
		<constant value="PackagesTools"/>
		<constant value="links"/>
		<constant value="NTransientLinkSet;"/>
		<constant value="col"/>
		<constant value="J"/>
		<constant value="main"/>
		<constant value="A"/>
		<constant value="OclParametrizedType"/>
		<constant value="#native"/>
		<constant value="Collection"/>
		<constant value="J.setName(S):V"/>
		<constant value="OclSimpleType"/>
		<constant value="OclAny"/>
		<constant value="J.setElementType(J):V"/>
		<constant value="TransientLinkSet"/>
		<constant value="A.__matcher__():V"/>
		<constant value="A.__exec__():V"/>
		<constant value="self"/>
		<constant value="__resolve__"/>
		<constant value="1"/>
		<constant value="J.oclIsKindOf(J):B"/>
		<constant value="18"/>
		<constant value="NTransientLinkSet;.getLinkBySourceElement(S):QNTransientLink;"/>
		<constant value="J.oclIsUndefined():B"/>
		<constant value="15"/>
		<constant value="NTransientLink;.getTargetFromSource(J):J"/>
		<constant value="17"/>
		<constant value="30"/>
		<constant value="Sequence"/>
		<constant value="2"/>
		<constant value="A.__resolve__(J):J"/>
		<constant value="QJ.including(J):QJ"/>
		<constant value="QJ.flatten():QJ"/>
		<constant value="e"/>
		<constant value="value"/>
		<constant value="resolveTemp"/>
		<constant value="S"/>
		<constant value="NTransientLink;.getNamedTargetFromSource(JS):J"/>
		<constant value="name"/>
		<constant value="__matcher__"/>
		<constant value="__exec__"/>
		<constant value="addImportedUnit"/>
		<constant value="3"/>
		<constant value="ModelUnit"/>
		<constant value="AADLBA"/>
		<constant value="J.allInstancesFrom(J):J"/>
		<constant value="4"/>
		<constant value="J.=(J):J"/>
		<constant value="B.not():B"/>
		<constant value="CJ.including(J):CJ"/>
		<constant value="CJ.asSequence():QJ"/>
		<constant value="QJ.first():J"/>
		<constant value="OUT"/>
		<constant value="5"/>
		<constant value="40"/>
		<constant value="J.oclIsUndefined():J"/>
		<constant value="48"/>
		<constant value="52"/>
		<constant value="importedUnit"/>
		<constant value="J.add(J):J"/>
		<constant value="47:28-47:44"/>
		<constant value="47:63-47:68"/>
		<constant value="47:28-47:69"/>
		<constant value="47:77-47:78"/>
		<constant value="47:77-47:83"/>
		<constant value="47:86-47:101"/>
		<constant value="47:77-47:101"/>
		<constant value="47:28-47:102"/>
		<constant value="48:32-48:48"/>
		<constant value="48:67-48:72"/>
		<constant value="48:32-48:73"/>
		<constant value="48:81-48:82"/>
		<constant value="48:81-48:87"/>
		<constant value="48:90-48:105"/>
		<constant value="48:81-48:105"/>
		<constant value="48:32-48:106"/>
		<constant value="48:32-48:123"/>
		<constant value="52:6-52:22"/>
		<constant value="54:4-54:14"/>
		<constant value="54:4-54:27"/>
		<constant value="54:32-54:36"/>
		<constant value="54:4-54:38"/>
		<constant value="52:3-55:4"/>
		<constant value="50:2-56:3"/>
		<constant value="unit"/>
		<constant value="isNotYetImported"/>
		<constant value="packageImg"/>
		<constant value="model"/>
		<constant value="importedPackage"/>
		<constant value="addImportedUnitFromElt"/>
		<constant value="J.getNamespace():J"/>
		<constant value="J.getOwner():J"/>
		<constant value="IN"/>
		<constant value="23"/>
		<constant value="43"/>
		<constant value="51"/>
		<constant value="55"/>
		<constant value="63:37-63:40"/>
		<constant value="63:37-63:55"/>
		<constant value="63:37-63:66"/>
		<constant value="64:28-64:44"/>
		<constant value="64:63-64:67"/>
		<constant value="64:28-64:68"/>
		<constant value="64:76-64:77"/>
		<constant value="64:76-64:82"/>
		<constant value="64:85-64:96"/>
		<constant value="64:85-64:101"/>
		<constant value="64:76-64:101"/>
		<constant value="64:28-64:102"/>
		<constant value="65:32-65:42"/>
		<constant value="65:32-65:55"/>
		<constant value="65:63-65:64"/>
		<constant value="65:63-65:69"/>
		<constant value="65:72-65:83"/>
		<constant value="65:72-65:88"/>
		<constant value="65:63-65:88"/>
		<constant value="65:32-65:89"/>
		<constant value="65:32-65:106"/>
		<constant value="69:6-69:22"/>
		<constant value="71:4-71:14"/>
		<constant value="71:4-71:27"/>
		<constant value="71:32-71:43"/>
		<constant value="71:4-71:45"/>
		<constant value="69:3-72:4"/>
		<constant value="67:2-73:3"/>
		<constant value="src_package"/>
		<constant value="elt"/>
	</cp>
	<field name="1" type="2"/>
	<field name="3" type="4"/>
	<operation name="5">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<getasm/>
			<push arg="7"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="9"/>
			<pcall arg="10"/>
			<dup/>
			<push arg="11"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="12"/>
			<pcall arg="10"/>
			<pcall arg="13"/>
			<set arg="3"/>
			<getasm/>
			<push arg="14"/>
			<push arg="8"/>
			<new/>
			<set arg="1"/>
			<getasm/>
			<pcall arg="15"/>
			<getasm/>
			<pcall arg="16"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="24"/>
		</localvariabletable>
	</operation>
	<operation name="18">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="4"/>
		</parameters>
		<code>
			<load arg="19"/>
			<getasm/>
			<get arg="3"/>
			<call arg="20"/>
			<if arg="21"/>
			<getasm/>
			<get arg="1"/>
			<load arg="19"/>
			<call arg="22"/>
			<dup/>
			<call arg="23"/>
			<if arg="24"/>
			<load arg="19"/>
			<call arg="25"/>
			<goto arg="26"/>
			<pop/>
			<load arg="19"/>
			<goto arg="27"/>
			<push arg="28"/>
			<push arg="8"/>
			<new/>
			<load arg="19"/>
			<iterate/>
			<store arg="29"/>
			<getasm/>
			<load arg="29"/>
			<call arg="30"/>
			<call arg="31"/>
			<enditerate/>
			<call arg="32"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="2" name="33" begin="23" end="27"/>
			<lve slot="0" name="17" begin="0" end="29"/>
			<lve slot="1" name="34" begin="0" end="29"/>
		</localvariabletable>
	</operation>
	<operation name="35">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="4"/>
			<parameter name="29" type="36"/>
		</parameters>
		<code>
			<getasm/>
			<get arg="1"/>
			<load arg="19"/>
			<call arg="22"/>
			<load arg="19"/>
			<load arg="29"/>
			<call arg="37"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="6"/>
			<lve slot="1" name="34" begin="0" end="6"/>
			<lve slot="2" name="38" begin="0" end="6"/>
		</localvariabletable>
	</operation>
	<operation name="39">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="-1"/>
		</localvariabletable>
	</operation>
	<operation name="40">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="-1"/>
		</localvariabletable>
	</operation>
	<operation name="41">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="4"/>
			<parameter name="29" type="4"/>
			<parameter name="42" type="4"/>
		</parameters>
		<code>
			<push arg="28"/>
			<push arg="8"/>
			<new/>
			<push arg="43"/>
			<push arg="44"/>
			<findme/>
			<load arg="29"/>
			<call arg="45"/>
			<iterate/>
			<store arg="46"/>
			<load arg="46"/>
			<get arg="38"/>
			<load arg="42"/>
			<call arg="47"/>
			<call arg="48"/>
			<if arg="21"/>
			<load arg="46"/>
			<call arg="49"/>
			<enditerate/>
			<call arg="50"/>
			<call arg="51"/>
			<store arg="46"/>
			<push arg="28"/>
			<push arg="8"/>
			<new/>
			<push arg="43"/>
			<push arg="44"/>
			<findme/>
			<push arg="52"/>
			<call arg="45"/>
			<iterate/>
			<store arg="53"/>
			<load arg="53"/>
			<get arg="38"/>
			<load arg="42"/>
			<call arg="47"/>
			<call arg="48"/>
			<if arg="54"/>
			<load arg="53"/>
			<call arg="49"/>
			<enditerate/>
			<call arg="50"/>
			<call arg="51"/>
			<call arg="55"/>
			<store arg="53"/>
			<load arg="53"/>
			<if arg="56"/>
			<goto arg="57"/>
			<load arg="19"/>
			<get arg="58"/>
			<load arg="46"/>
			<pcall arg="59"/>
		</code>
		<linenumbertable>
			<lne id="60" begin="3" end="5"/>
			<lne id="61" begin="6" end="6"/>
			<lne id="62" begin="3" end="7"/>
			<lne id="63" begin="10" end="10"/>
			<lne id="64" begin="10" end="11"/>
			<lne id="65" begin="12" end="12"/>
			<lne id="66" begin="10" end="13"/>
			<lne id="67" begin="0" end="20"/>
			<lne id="68" begin="25" end="27"/>
			<lne id="69" begin="28" end="28"/>
			<lne id="70" begin="25" end="29"/>
			<lne id="71" begin="32" end="32"/>
			<lne id="72" begin="32" end="33"/>
			<lne id="73" begin="34" end="34"/>
			<lne id="74" begin="32" end="35"/>
			<lne id="75" begin="22" end="42"/>
			<lne id="76" begin="22" end="43"/>
			<lne id="77" begin="45" end="45"/>
			<lne id="78" begin="48" end="48"/>
			<lne id="79" begin="48" end="49"/>
			<lne id="80" begin="50" end="50"/>
			<lne id="81" begin="48" end="51"/>
			<lne id="82" begin="45" end="51"/>
			<lne id="83" begin="45" end="51"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="4" name="33" begin="9" end="17"/>
			<lve slot="5" name="33" begin="31" end="39"/>
			<lve slot="4" name="84" begin="21" end="51"/>
			<lve slot="5" name="85" begin="44" end="51"/>
			<lve slot="0" name="17" begin="0" end="51"/>
			<lve slot="1" name="86" begin="0" end="51"/>
			<lve slot="2" name="87" begin="0" end="51"/>
			<lve slot="3" name="88" begin="0" end="51"/>
		</localvariabletable>
	</operation>
	<operation name="89">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="4"/>
			<parameter name="29" type="4"/>
		</parameters>
		<code>
			<load arg="29"/>
			<call arg="90"/>
			<call arg="91"/>
			<store arg="42"/>
			<push arg="28"/>
			<push arg="8"/>
			<new/>
			<push arg="43"/>
			<push arg="44"/>
			<findme/>
			<push arg="92"/>
			<call arg="45"/>
			<iterate/>
			<store arg="46"/>
			<load arg="46"/>
			<get arg="38"/>
			<load arg="42"/>
			<get arg="38"/>
			<call arg="47"/>
			<call arg="48"/>
			<if arg="93"/>
			<load arg="46"/>
			<call arg="49"/>
			<enditerate/>
			<call arg="50"/>
			<call arg="51"/>
			<store arg="46"/>
			<push arg="28"/>
			<push arg="8"/>
			<new/>
			<load arg="19"/>
			<get arg="58"/>
			<iterate/>
			<store arg="53"/>
			<load arg="53"/>
			<get arg="38"/>
			<load arg="42"/>
			<get arg="38"/>
			<call arg="47"/>
			<call arg="48"/>
			<if arg="94"/>
			<load arg="53"/>
			<call arg="49"/>
			<enditerate/>
			<call arg="50"/>
			<call arg="51"/>
			<call arg="55"/>
			<store arg="53"/>
			<load arg="53"/>
			<if arg="95"/>
			<goto arg="96"/>
			<load arg="19"/>
			<get arg="58"/>
			<load arg="42"/>
			<pcall arg="59"/>
		</code>
		<linenumbertable>
			<lne id="97" begin="0" end="0"/>
			<lne id="98" begin="0" end="1"/>
			<lne id="99" begin="0" end="2"/>
			<lne id="100" begin="7" end="9"/>
			<lne id="101" begin="10" end="10"/>
			<lne id="102" begin="7" end="11"/>
			<lne id="103" begin="14" end="14"/>
			<lne id="104" begin="14" end="15"/>
			<lne id="105" begin="16" end="16"/>
			<lne id="106" begin="16" end="17"/>
			<lne id="107" begin="14" end="18"/>
			<lne id="108" begin="4" end="25"/>
			<lne id="109" begin="30" end="30"/>
			<lne id="110" begin="30" end="31"/>
			<lne id="111" begin="34" end="34"/>
			<lne id="112" begin="34" end="35"/>
			<lne id="113" begin="36" end="36"/>
			<lne id="114" begin="36" end="37"/>
			<lne id="115" begin="34" end="38"/>
			<lne id="116" begin="27" end="45"/>
			<lne id="117" begin="27" end="46"/>
			<lne id="118" begin="48" end="48"/>
			<lne id="119" begin="51" end="51"/>
			<lne id="120" begin="51" end="52"/>
			<lne id="121" begin="53" end="53"/>
			<lne id="122" begin="51" end="54"/>
			<lne id="123" begin="48" end="54"/>
			<lne id="124" begin="48" end="54"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="4" name="33" begin="13" end="22"/>
			<lve slot="5" name="33" begin="33" end="42"/>
			<lve slot="3" name="125" begin="3" end="54"/>
			<lve slot="4" name="84" begin="26" end="54"/>
			<lve slot="5" name="85" begin="47" end="54"/>
			<lve slot="0" name="17" begin="0" end="54"/>
			<lve slot="1" name="86" begin="0" end="54"/>
			<lve slot="2" name="126" begin="0" end="54"/>
		</localvariabletable>
	</operation>
</asm>
