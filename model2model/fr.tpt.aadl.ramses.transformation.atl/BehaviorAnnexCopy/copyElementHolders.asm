<?xml version = '1.0' encoding = 'ISO-8859-1' ?>
<asm version="1.0" name="0">
	<cp>
		<constant value="CopyElementHolders"/>
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
		<constant value="copySubprogramAccessHolder"/>
		<constant value="MAADLBA!SubprogramAccessHolder;"/>
		<constant value="TransientLink"/>
		<constant value="NTransientLink;.setRule(MATL!Rule;):V"/>
		<constant value="src_SubprogramAccessHolder"/>
		<constant value="NTransientLink;.addSourceElement(SJ):V"/>
		<constant value="target_SubprogramAccessHolder"/>
		<constant value="SubprogramAccessHolder"/>
		<constant value="AADLBA"/>
		<constant value="NTransientLink;.addTargetElement(SJ):V"/>
		<constant value="NTransientLinkSet;.addLink2(NTransientLink;B):V"/>
		<constant value="element"/>
		<constant value="34:13-34:39"/>
		<constant value="34:13-34:47"/>
		<constant value="34:4-34:47"/>
		<constant value="32:3-35:4"/>
		<constant value="38:3-38:32"/>
		<constant value="38:3-38:33"/>
		<constant value="36:2-39:3"/>
		<constant value="copyEventPortHolder"/>
		<constant value="MAADLBA!EventPortHolder;"/>
		<constant value="src_EventPortHolder"/>
		<constant value="target_EventPortHolder"/>
		<constant value="EventPortHolder"/>
		<constant value="49:13-49:32"/>
		<constant value="49:13-49:40"/>
		<constant value="49:4-49:40"/>
		<constant value="47:3-50:4"/>
		<constant value="53:3-53:25"/>
		<constant value="53:3-53:26"/>
		<constant value="51:2-54:3"/>
		<constant value="copyEventDataPortHolder"/>
		<constant value="MAADLBA!EventDataPortHolder;"/>
		<constant value="src_EventDataPortHolder"/>
		<constant value="target_EventDataPortHolder"/>
		<constant value="EventDataPortHolder"/>
		<constant value="64:13-64:36"/>
		<constant value="64:13-64:44"/>
		<constant value="64:4-64:44"/>
		<constant value="62:3-65:4"/>
		<constant value="68:3-68:29"/>
		<constant value="68:3-68:30"/>
		<constant value="66:2-69:3"/>
		<constant value="copyDataPortHolder"/>
		<constant value="MAADLBA!DataPortHolder;"/>
		<constant value="src_DataPortHolder"/>
		<constant value="target_DataPortHolder"/>
		<constant value="DataPortHolder"/>
		<constant value="79:13-79:31"/>
		<constant value="79:13-79:39"/>
		<constant value="79:4-79:39"/>
		<constant value="77:3-80:4"/>
		<constant value="83:3-83:24"/>
		<constant value="83:3-83:25"/>
		<constant value="81:2-84:3"/>
		<constant value="copyCalledSubprogramHolder"/>
		<constant value="MAADLBA!CalledSubprogramHolder;"/>
		<constant value="src_CalledSubprogramHolder"/>
		<constant value="target_CalledSubprogramHolder"/>
		<constant value="CalledSubprogramHolder"/>
		<constant value="94:13-94:39"/>
		<constant value="94:13-94:47"/>
		<constant value="94:4-94:47"/>
		<constant value="92:3-95:4"/>
		<constant value="98:3-98:32"/>
		<constant value="98:3-98:33"/>
		<constant value="96:2-99:3"/>
		<constant value="copyDataAccessHolder"/>
		<constant value="MAADLBA!DataAccessHolder;"/>
		<constant value="src_DataAccessHolder"/>
		<constant value="target_DataAccessHolder"/>
		<constant value="DataAccessHolder"/>
		<constant value="109:13-109:33"/>
		<constant value="109:13-109:41"/>
		<constant value="109:4-109:41"/>
		<constant value="107:3-110:4"/>
		<constant value="113:3-113:26"/>
		<constant value="113:3-113:27"/>
		<constant value="111:2-114:3"/>
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
			<parameter name="19" type="42"/>
		</parameters>
		<code>
			<getasm/>
			<get arg="1"/>
			<push arg="43"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="41"/>
			<pcall arg="44"/>
			<dup/>
			<push arg="45"/>
			<load arg="19"/>
			<pcall arg="46"/>
			<dup/>
			<push arg="47"/>
			<push arg="48"/>
			<push arg="49"/>
			<new/>
			<dup/>
			<store arg="29"/>
			<pcall arg="50"/>
			<pushf/>
			<pcall arg="51"/>
			<load arg="29"/>
			<dup/>
			<getasm/>
			<load arg="19"/>
			<get arg="52"/>
			<call arg="30"/>
			<set arg="52"/>
			<pop/>
			<load arg="29"/>
			<load arg="29"/>
		</code>
		<linenumbertable>
			<lne id="53" begin="25" end="25"/>
			<lne id="54" begin="25" end="26"/>
			<lne id="55" begin="23" end="28"/>
			<lne id="56" begin="22" end="29"/>
			<lne id="57" begin="30" end="30"/>
			<lne id="58" begin="30" end="30"/>
			<lne id="59" begin="30" end="30"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="2" name="47" begin="18" end="31"/>
			<lve slot="0" name="17" begin="0" end="31"/>
			<lve slot="1" name="45" begin="0" end="31"/>
		</localvariabletable>
	</operation>
	<operation name="60">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="61"/>
		</parameters>
		<code>
			<getasm/>
			<get arg="1"/>
			<push arg="43"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="60"/>
			<pcall arg="44"/>
			<dup/>
			<push arg="62"/>
			<load arg="19"/>
			<pcall arg="46"/>
			<dup/>
			<push arg="63"/>
			<push arg="64"/>
			<push arg="49"/>
			<new/>
			<dup/>
			<store arg="29"/>
			<pcall arg="50"/>
			<pushf/>
			<pcall arg="51"/>
			<load arg="29"/>
			<dup/>
			<getasm/>
			<load arg="19"/>
			<get arg="52"/>
			<call arg="30"/>
			<set arg="52"/>
			<pop/>
			<load arg="29"/>
			<load arg="29"/>
		</code>
		<linenumbertable>
			<lne id="65" begin="25" end="25"/>
			<lne id="66" begin="25" end="26"/>
			<lne id="67" begin="23" end="28"/>
			<lne id="68" begin="22" end="29"/>
			<lne id="69" begin="30" end="30"/>
			<lne id="70" begin="30" end="30"/>
			<lne id="71" begin="30" end="30"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="2" name="63" begin="18" end="31"/>
			<lve slot="0" name="17" begin="0" end="31"/>
			<lve slot="1" name="62" begin="0" end="31"/>
		</localvariabletable>
	</operation>
	<operation name="72">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="73"/>
		</parameters>
		<code>
			<getasm/>
			<get arg="1"/>
			<push arg="43"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="72"/>
			<pcall arg="44"/>
			<dup/>
			<push arg="74"/>
			<load arg="19"/>
			<pcall arg="46"/>
			<dup/>
			<push arg="75"/>
			<push arg="76"/>
			<push arg="49"/>
			<new/>
			<dup/>
			<store arg="29"/>
			<pcall arg="50"/>
			<pushf/>
			<pcall arg="51"/>
			<load arg="29"/>
			<dup/>
			<getasm/>
			<load arg="19"/>
			<get arg="52"/>
			<call arg="30"/>
			<set arg="52"/>
			<pop/>
			<load arg="29"/>
			<load arg="29"/>
		</code>
		<linenumbertable>
			<lne id="77" begin="25" end="25"/>
			<lne id="78" begin="25" end="26"/>
			<lne id="79" begin="23" end="28"/>
			<lne id="80" begin="22" end="29"/>
			<lne id="81" begin="30" end="30"/>
			<lne id="82" begin="30" end="30"/>
			<lne id="83" begin="30" end="30"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="2" name="75" begin="18" end="31"/>
			<lve slot="0" name="17" begin="0" end="31"/>
			<lve slot="1" name="74" begin="0" end="31"/>
		</localvariabletable>
	</operation>
	<operation name="84">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="85"/>
		</parameters>
		<code>
			<getasm/>
			<get arg="1"/>
			<push arg="43"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="84"/>
			<pcall arg="44"/>
			<dup/>
			<push arg="86"/>
			<load arg="19"/>
			<pcall arg="46"/>
			<dup/>
			<push arg="87"/>
			<push arg="88"/>
			<push arg="49"/>
			<new/>
			<dup/>
			<store arg="29"/>
			<pcall arg="50"/>
			<pushf/>
			<pcall arg="51"/>
			<load arg="29"/>
			<dup/>
			<getasm/>
			<load arg="19"/>
			<get arg="52"/>
			<call arg="30"/>
			<set arg="52"/>
			<pop/>
			<load arg="29"/>
			<load arg="29"/>
		</code>
		<linenumbertable>
			<lne id="89" begin="25" end="25"/>
			<lne id="90" begin="25" end="26"/>
			<lne id="91" begin="23" end="28"/>
			<lne id="92" begin="22" end="29"/>
			<lne id="93" begin="30" end="30"/>
			<lne id="94" begin="30" end="30"/>
			<lne id="95" begin="30" end="30"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="2" name="87" begin="18" end="31"/>
			<lve slot="0" name="17" begin="0" end="31"/>
			<lve slot="1" name="86" begin="0" end="31"/>
		</localvariabletable>
	</operation>
	<operation name="96">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="97"/>
		</parameters>
		<code>
			<getasm/>
			<get arg="1"/>
			<push arg="43"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="96"/>
			<pcall arg="44"/>
			<dup/>
			<push arg="98"/>
			<load arg="19"/>
			<pcall arg="46"/>
			<dup/>
			<push arg="99"/>
			<push arg="100"/>
			<push arg="49"/>
			<new/>
			<dup/>
			<store arg="29"/>
			<pcall arg="50"/>
			<pushf/>
			<pcall arg="51"/>
			<load arg="29"/>
			<dup/>
			<getasm/>
			<load arg="19"/>
			<get arg="52"/>
			<call arg="30"/>
			<set arg="52"/>
			<pop/>
			<load arg="29"/>
			<load arg="29"/>
		</code>
		<linenumbertable>
			<lne id="101" begin="25" end="25"/>
			<lne id="102" begin="25" end="26"/>
			<lne id="103" begin="23" end="28"/>
			<lne id="104" begin="22" end="29"/>
			<lne id="105" begin="30" end="30"/>
			<lne id="106" begin="30" end="30"/>
			<lne id="107" begin="30" end="30"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="2" name="99" begin="18" end="31"/>
			<lve slot="0" name="17" begin="0" end="31"/>
			<lve slot="1" name="98" begin="0" end="31"/>
		</localvariabletable>
	</operation>
	<operation name="108">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="109"/>
		</parameters>
		<code>
			<getasm/>
			<get arg="1"/>
			<push arg="43"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="108"/>
			<pcall arg="44"/>
			<dup/>
			<push arg="110"/>
			<load arg="19"/>
			<pcall arg="46"/>
			<dup/>
			<push arg="111"/>
			<push arg="112"/>
			<push arg="49"/>
			<new/>
			<dup/>
			<store arg="29"/>
			<pcall arg="50"/>
			<pushf/>
			<pcall arg="51"/>
			<load arg="29"/>
			<dup/>
			<getasm/>
			<load arg="19"/>
			<get arg="52"/>
			<call arg="30"/>
			<set arg="52"/>
			<pop/>
			<load arg="29"/>
			<load arg="29"/>
		</code>
		<linenumbertable>
			<lne id="113" begin="25" end="25"/>
			<lne id="114" begin="25" end="26"/>
			<lne id="115" begin="23" end="28"/>
			<lne id="116" begin="22" end="29"/>
			<lne id="117" begin="30" end="30"/>
			<lne id="118" begin="30" end="30"/>
			<lne id="119" begin="30" end="30"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="2" name="111" begin="18" end="31"/>
			<lve slot="0" name="17" begin="0" end="31"/>
			<lve slot="1" name="110" begin="0" end="31"/>
		</localvariabletable>
	</operation>
</asm>
