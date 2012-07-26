<?xml version = '1.0' encoding = 'ISO-8859-1' ?>
<asm version="1.0" name="0">
	<cp>
		<constant value="Misc"/>
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
		<constant value="A.__matchComment():V"/>
		<constant value="__exec__"/>
		<constant value="Comment"/>
		<constant value="NTransientLinkSet;.getLinksByRule(S):QNTransientLink;"/>
		<constant value="A.__applyComment(NTransientLink;):V"/>
		<constant value="SubprogramCall"/>
		<constant value="3"/>
		<constant value="AADLBA"/>
		<constant value="4"/>
		<constant value="calledSubprogram"/>
		<constant value="SubprogramType"/>
		<constant value="AADLI"/>
		<constant value="J.oclIsKindOf(J):J"/>
		<constant value="35"/>
		<constant value="QJ.first():J"/>
		<constant value="J.getOwnedRealization():J"/>
		<constant value="implemented"/>
		<constant value="J.Type(J):J"/>
		<constant value="J.Implementation(JJJ):J"/>
		<constant value="39"/>
		<constant value="43:12-43:13"/>
		<constant value="43:12-43:18"/>
		<constant value="43:4-43:18"/>
		<constant value="44:28-44:29"/>
		<constant value="44:28-44:46"/>
		<constant value="44:59-44:79"/>
		<constant value="44:28-44:80"/>
		<constant value="47:10-47:20"/>
		<constant value="47:36-47:48"/>
		<constant value="47:49-47:50"/>
		<constant value="47:49-47:67"/>
		<constant value="47:69-47:79"/>
		<constant value="47:85-47:86"/>
		<constant value="47:85-47:103"/>
		<constant value="47:85-47:125"/>
		<constant value="47:85-47:137"/>
		<constant value="47:69-47:138"/>
		<constant value="47:10-47:139"/>
		<constant value="45:10-45:20"/>
		<constant value="45:26-45:27"/>
		<constant value="45:26-45:44"/>
		<constant value="45:10-45:45"/>
		<constant value="44:24-48:14"/>
		<constant value="44:4-48:14"/>
		<constant value="50:7-50:9"/>
		<constant value="50:7-50:10"/>
		<constant value="50:2-50:12"/>
		<constant value="s2"/>
		<constant value="s"/>
		<constant value="impl"/>
		<constant value="implImg"/>
		<constant value="__matchComment"/>
		<constant value="IN"/>
		<constant value="MMOF!Classifier;.allInstancesFrom(S):QJ"/>
		<constant value="TransientLink"/>
		<constant value="NTransientLink;.setRule(MATL!Rule;):V"/>
		<constant value="c"/>
		<constant value="NTransientLink;.addSourceElement(SJ):V"/>
		<constant value="c2"/>
		<constant value="NTransientLink;.addTargetElement(SJ):V"/>
		<constant value="NTransientLinkSet;.addLink2(NTransientLink;B):V"/>
		<constant value="57:3-57:70"/>
		<constant value="__applyComment"/>
		<constant value="NTransientLink;"/>
		<constant value="NTransientLink;.getSourceElement(S):J"/>
		<constant value="NTransientLink;.getTargetElement(S):J"/>
		<constant value="body"/>
		<constant value="ownedComment"/>
		<constant value="57:31-57:32"/>
		<constant value="57:31-57:37"/>
		<constant value="57:23-57:37"/>
		<constant value="57:55-57:56"/>
		<constant value="57:55-57:69"/>
		<constant value="57:39-57:69"/>
		<constant value="link"/>
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
			<getasm/>
			<pcall arg="40"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="1"/>
		</localvariabletable>
	</operation>
	<operation name="41">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<getasm/>
			<get arg="1"/>
			<push arg="42"/>
			<call arg="43"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<load arg="19"/>
			<pcall arg="44"/>
			<enditerate/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="33" begin="5" end="8"/>
			<lve slot="0" name="17" begin="0" end="9"/>
		</localvariabletable>
	</operation>
	<operation name="45">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="4"/>
			<parameter name="29" type="4"/>
			<parameter name="46" type="4"/>
		</parameters>
		<code>
			<push arg="45"/>
			<push arg="47"/>
			<new/>
			<store arg="48"/>
			<load arg="48"/>
			<dup/>
			<getasm/>
			<load arg="19"/>
			<get arg="38"/>
			<call arg="30"/>
			<set arg="38"/>
			<dup/>
			<getasm/>
			<load arg="19"/>
			<get arg="49"/>
			<push arg="50"/>
			<push arg="51"/>
			<findme/>
			<call arg="52"/>
			<if arg="53"/>
			<getasm/>
			<push arg="28"/>
			<push arg="8"/>
			<new/>
			<call arg="54"/>
			<load arg="19"/>
			<get arg="49"/>
			<getasm/>
			<load arg="19"/>
			<get arg="49"/>
			<call arg="55"/>
			<get arg="56"/>
			<call arg="57"/>
			<call arg="58"/>
			<goto arg="59"/>
			<getasm/>
			<load arg="19"/>
			<get arg="49"/>
			<call arg="57"/>
			<call arg="30"/>
			<set arg="49"/>
			<pop/>
			<load arg="48"/>
		</code>
		<linenumbertable>
			<lne id="60" begin="7" end="7"/>
			<lne id="61" begin="7" end="8"/>
			<lne id="62" begin="5" end="10"/>
			<lne id="63" begin="13" end="13"/>
			<lne id="64" begin="13" end="14"/>
			<lne id="65" begin="15" end="17"/>
			<lne id="66" begin="13" end="18"/>
			<lne id="67" begin="20" end="20"/>
			<lne id="68" begin="21" end="24"/>
			<lne id="69" begin="25" end="25"/>
			<lne id="70" begin="25" end="26"/>
			<lne id="71" begin="27" end="27"/>
			<lne id="72" begin="28" end="28"/>
			<lne id="73" begin="28" end="29"/>
			<lne id="74" begin="28" end="30"/>
			<lne id="75" begin="28" end="31"/>
			<lne id="76" begin="27" end="32"/>
			<lne id="77" begin="20" end="33"/>
			<lne id="78" begin="35" end="35"/>
			<lne id="79" begin="36" end="36"/>
			<lne id="80" begin="36" end="37"/>
			<lne id="81" begin="35" end="38"/>
			<lne id="82" begin="13" end="38"/>
			<lne id="83" begin="11" end="40"/>
			<lne id="84" begin="42" end="42"/>
			<lne id="85" begin="42" end="42"/>
			<lne id="86" begin="42" end="42"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="4" name="87" begin="3" end="42"/>
			<lve slot="0" name="17" begin="0" end="42"/>
			<lve slot="1" name="88" begin="0" end="42"/>
			<lve slot="2" name="89" begin="0" end="42"/>
			<lve slot="3" name="90" begin="0" end="42"/>
		</localvariabletable>
	</operation>
	<operation name="91">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<push arg="42"/>
			<push arg="51"/>
			<findme/>
			<push arg="92"/>
			<call arg="93"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<get arg="1"/>
			<push arg="94"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="42"/>
			<pcall arg="95"/>
			<dup/>
			<push arg="96"/>
			<load arg="19"/>
			<pcall arg="97"/>
			<dup/>
			<push arg="98"/>
			<push arg="42"/>
			<push arg="47"/>
			<new/>
			<pcall arg="99"/>
			<pusht/>
			<pcall arg="100"/>
			<enditerate/>
		</code>
		<linenumbertable>
			<lne id="101" begin="19" end="24"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="96" begin="6" end="26"/>
			<lve slot="0" name="17" begin="0" end="27"/>
		</localvariabletable>
	</operation>
	<operation name="102">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="103"/>
		</parameters>
		<code>
			<load arg="19"/>
			<push arg="96"/>
			<call arg="104"/>
			<store arg="29"/>
			<load arg="19"/>
			<push arg="98"/>
			<call arg="105"/>
			<store arg="46"/>
			<load arg="46"/>
			<dup/>
			<getasm/>
			<load arg="29"/>
			<get arg="106"/>
			<call arg="30"/>
			<set arg="106"/>
			<dup/>
			<getasm/>
			<load arg="29"/>
			<get arg="107"/>
			<call arg="30"/>
			<set arg="107"/>
			<pop/>
		</code>
		<linenumbertable>
			<lne id="108" begin="11" end="11"/>
			<lne id="109" begin="11" end="12"/>
			<lne id="110" begin="9" end="14"/>
			<lne id="111" begin="17" end="17"/>
			<lne id="112" begin="17" end="18"/>
			<lne id="113" begin="15" end="20"/>
			<lne id="101" begin="8" end="21"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="3" name="98" begin="7" end="21"/>
			<lve slot="2" name="96" begin="3" end="21"/>
			<lve slot="0" name="17" begin="0" end="21"/>
			<lve slot="1" name="114" begin="0" end="21"/>
		</localvariabletable>
	</operation>
</asm>
