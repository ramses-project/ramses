<?xml version = '1.0' encoding = 'ISO-8859-1' ?>
<asm version="1.0" name="0">
	<cp>
		<constant value="FeatureTools"/>
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
		<constant value="addSubprogramCall"/>
		<constant value="3"/>
		<constant value="ownedSubprogramCallSequence"/>
		<constant value="J.isEmpty():J"/>
		<constant value="57"/>
		<constant value="J.getOwnedSubprogramCallSequences():J"/>
		<constant value="4"/>
		<constant value="direction"/>
		<constant value="J.toString():J"/>
		<constant value="in"/>
		<constant value="J.=(J):J"/>
		<constant value="EnumLiteral"/>
		<constant value="inOut"/>
		<constant value="J.or(J):J"/>
		<constant value="25"/>
		<constant value="J.getOwnedCallSpecifications():J"/>
		<constant value="0"/>
		<constant value="J.add(JJ):J"/>
		<constant value="out"/>
		<constant value="51"/>
		<constant value="55"/>
		<constant value="J.add(J):J"/>
		<constant value="63"/>
		<constant value="J.createCallSequence(J):J"/>
		<constant value="51:6-51:13"/>
		<constant value="51:6-51:41"/>
		<constant value="51:6-51:52"/>
		<constant value="57:15-57:22"/>
		<constant value="57:15-57:56"/>
		<constant value="59:8-59:9"/>
		<constant value="59:8-59:19"/>
		<constant value="59:8-59:30"/>
		<constant value="59:31-59:35"/>
		<constant value="59:8-59:35"/>
		<constant value="59:39-59:40"/>
		<constant value="59:39-59:50"/>
		<constant value="59:51-59:57"/>
		<constant value="59:39-59:57"/>
		<constant value="59:8-59:57"/>
		<constant value="60:6-60:9"/>
		<constant value="60:6-60:38"/>
		<constant value="60:43-60:44"/>
		<constant value="60:46-60:50"/>
		<constant value="60:6-60:52"/>
		<constant value="59:5-60:52"/>
		<constant value="61:9-61:10"/>
		<constant value="61:9-61:20"/>
		<constant value="61:21-61:25"/>
		<constant value="61:9-61:25"/>
		<constant value="61:29-61:30"/>
		<constant value="61:29-61:40"/>
		<constant value="61:41-61:47"/>
		<constant value="61:29-61:47"/>
		<constant value="61:9-61:47"/>
		<constant value="62:6-62:9"/>
		<constant value="62:6-62:38"/>
		<constant value="62:43-62:47"/>
		<constant value="62:6-62:49"/>
		<constant value="61:5-62:49"/>
		<constant value="57:4-63:5"/>
		<constant value="53:4-53:11"/>
		<constant value="53:4-53:39"/>
		<constant value="53:44-53:54"/>
		<constant value="53:74-53:78"/>
		<constant value="53:44-53:79"/>
		<constant value="53:4-53:81"/>
		<constant value="51:3-64:4"/>
		<constant value="49:2-66:3"/>
		<constant value="seq"/>
		<constant value="f"/>
		<constant value="implImg"/>
		<constant value="call"/>
		<constant value="CreateEventPort"/>
		<constant value="EventPort"/>
		<constant value="AADLBA"/>
		<constant value="71:33-71:41"/>
		<constant value="71:25-71:41"/>
		<constant value="71:56-71:59"/>
		<constant value="71:43-71:59"/>
		<constant value="72:6-72:7"/>
		<constant value="72:6-72:8"/>
		<constant value="72:2-72:9"/>
		<constant value="p"/>
		<constant value="portName"/>
		<constant value="dir"/>
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
			<load arg="29"/>
			<get arg="43"/>
			<call arg="44"/>
			<if arg="45"/>
			<load arg="29"/>
			<call arg="46"/>
			<iterate/>
			<store arg="47"/>
			<load arg="19"/>
			<get arg="48"/>
			<call arg="49"/>
			<push arg="50"/>
			<call arg="51"/>
			<load arg="19"/>
			<get arg="48"/>
			<push arg="52"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="53"/>
			<set arg="38"/>
			<call arg="51"/>
			<call arg="54"/>
			<if arg="55"/>
			<goto arg="27"/>
			<load arg="47"/>
			<call arg="56"/>
			<pushi arg="57"/>
			<load arg="42"/>
			<pcall arg="58"/>
			<load arg="19"/>
			<get arg="48"/>
			<push arg="52"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="59"/>
			<set arg="38"/>
			<call arg="51"/>
			<load arg="19"/>
			<get arg="48"/>
			<push arg="52"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="53"/>
			<set arg="38"/>
			<call arg="51"/>
			<call arg="54"/>
			<if arg="60"/>
			<goto arg="61"/>
			<load arg="47"/>
			<call arg="56"/>
			<load arg="42"/>
			<pcall arg="62"/>
			<enditerate/>
			<goto arg="63"/>
			<load arg="29"/>
			<get arg="43"/>
			<getasm/>
			<load arg="42"/>
			<call arg="64"/>
			<pcall arg="62"/>
		</code>
		<linenumbertable>
			<lne id="65" begin="0" end="0"/>
			<lne id="66" begin="0" end="1"/>
			<lne id="67" begin="0" end="2"/>
			<lne id="68" begin="4" end="4"/>
			<lne id="69" begin="4" end="5"/>
			<lne id="70" begin="8" end="8"/>
			<lne id="71" begin="8" end="9"/>
			<lne id="72" begin="8" end="10"/>
			<lne id="73" begin="11" end="11"/>
			<lne id="74" begin="8" end="12"/>
			<lne id="75" begin="13" end="13"/>
			<lne id="76" begin="13" end="14"/>
			<lne id="77" begin="15" end="20"/>
			<lne id="78" begin="13" end="21"/>
			<lne id="79" begin="8" end="22"/>
			<lne id="80" begin="25" end="25"/>
			<lne id="81" begin="25" end="26"/>
			<lne id="82" begin="27" end="27"/>
			<lne id="83" begin="28" end="28"/>
			<lne id="84" begin="25" end="29"/>
			<lne id="85" begin="8" end="29"/>
			<lne id="86" begin="30" end="30"/>
			<lne id="87" begin="30" end="31"/>
			<lne id="88" begin="32" end="37"/>
			<lne id="89" begin="30" end="38"/>
			<lne id="90" begin="39" end="39"/>
			<lne id="91" begin="39" end="40"/>
			<lne id="92" begin="41" end="46"/>
			<lne id="93" begin="39" end="47"/>
			<lne id="94" begin="30" end="48"/>
			<lne id="95" begin="51" end="51"/>
			<lne id="96" begin="51" end="52"/>
			<lne id="97" begin="53" end="53"/>
			<lne id="98" begin="51" end="54"/>
			<lne id="99" begin="30" end="54"/>
			<lne id="100" begin="4" end="55"/>
			<lne id="101" begin="57" end="57"/>
			<lne id="102" begin="57" end="58"/>
			<lne id="103" begin="59" end="59"/>
			<lne id="104" begin="60" end="60"/>
			<lne id="105" begin="59" end="61"/>
			<lne id="106" begin="57" end="62"/>
			<lne id="107" begin="0" end="62"/>
			<lne id="108" begin="0" end="62"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="4" name="109" begin="7" end="54"/>
			<lve slot="0" name="17" begin="0" end="62"/>
			<lve slot="1" name="110" begin="0" end="62"/>
			<lve slot="2" name="111" begin="0" end="62"/>
			<lve slot="3" name="112" begin="0" end="62"/>
		</localvariabletable>
	</operation>
	<operation name="113">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="4"/>
			<parameter name="29" type="4"/>
		</parameters>
		<code>
			<push arg="114"/>
			<push arg="115"/>
			<new/>
			<store arg="42"/>
			<load arg="42"/>
			<dup/>
			<getasm/>
			<load arg="19"/>
			<call arg="30"/>
			<set arg="38"/>
			<dup/>
			<getasm/>
			<load arg="29"/>
			<call arg="30"/>
			<set arg="48"/>
			<pop/>
			<load arg="42"/>
		</code>
		<linenumbertable>
			<lne id="116" begin="7" end="7"/>
			<lne id="117" begin="5" end="9"/>
			<lne id="118" begin="12" end="12"/>
			<lne id="119" begin="10" end="14"/>
			<lne id="120" begin="16" end="16"/>
			<lne id="121" begin="16" end="16"/>
			<lne id="122" begin="16" end="16"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="3" name="123" begin="3" end="16"/>
			<lve slot="0" name="17" begin="0" end="16"/>
			<lve slot="1" name="124" begin="0" end="16"/>
			<lve slot="2" name="125" begin="0" end="16"/>
		</localvariabletable>
	</operation>
</asm>
