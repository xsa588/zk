/* Attributes.java

	Purpose:
		
	Description:
		
	History:
		Sat Jan 16 10:28:21 TST 2010, Created by tomyeh

Copyright (C) 2010 Potix Corporation. All Rights Reserved.

*/
package org.zkoss.zk.ui.sys;

/**
 * Attributes or library properties to customize the behaviors of ZK,
 * such as page rending, fileupload and so on.
 *
 * @author tomyeh
 * @since 5.0.0
 */
public class Attributes {
	//Desktop//

	//Component/Page//
	/** A component or page attribute to indicate if the client ROD
	 * (render-on-demand) shall be applied.
	 * <p>Default: true.
	 * <p>Applicable: ZK EE
	 * @since 5.0.0
	 */
	public static final String CLIENT_ROD = "org.zkoss.zul.client.rod";

	//Execution/request//
	/** The execution attribute used to control how to redraw
	 * a page ({@link org.zkoss.zk.ui.sys.PageCtrl#redraw}).
	 * There are three different values: <code>destkop</code>,
	 * <code>page</code>, and <code>complete</code>.
	 *
	 * <p>Default: null (means auto). In other words, <code>desktop</code> is assumed
	 * if this is the top-level page and not being included (and other conditions).
	 * Otherwise, it assumes <code>page</code>.
	 *
	 * <p>Application developers rarely need to set this attribute, unless ZK Loader
	 * cannot decide which control to use correctly.
	 *
	 * <p>This control can also be specified as a request parameter called
	 * <code>zk.redrawCtrl</code>. For example, if you are using
	 * other technology, say jQuery, and want to load a ZUL page dynamically; as shown below:
<pre><code>
	$("#pos").load("frag.zul?zk.redrawCtrl=page");
</code></pre>
	 *
	 * <p>If you prefer to draw the desktop with the page, you can set the
	 * vallue to <code>desktop</code>. By drawing the desktop, it means HTML and BODY
	 * tags will be generated, too.
	 *
	 * <p>If you prefer to draw the page only (such as being included),
	 * you can set the value to <code>page</code>.
	 *
	 * <p>If the page already contains everything that the client expects such
	 * as the HTML and BODY tags, you can set the value to <code>complete</code>.
	 *
	 * <p>The difference between <code>page</code> and <code>complete</code> is
	 * a bit subtle. They don't generate HTML and BODY tags. However,
	 * <code>page</code> generates DIV to represents a page, while
	 * <code>complete</code> generates only the root components.
	 * Thus, <code>complete</code> is usually used for the situation that
	 * HTML and BODY are being generated by other technology, while
	 * <code>page</code> for a included ZK page.
	 *
	 * <p>Note: if {@link org.zkoss.zk.ui.Page#isComplete} is true, it has the same effect
	 * of setting {@link #PAGE_REDRAW_CONTROL} to <code>complete</code>.
	 * 
	 * @see org.zkoss.zk.ui.sys.ExecutionsCtrl#getPageRedrawControl
	 * @since 5.0.0
	 */
	public static final String PAGE_REDRAW_CONTROL = "org.zkoss.zk.ui.page.redrawCtrl";
	/** The execution attribute used to control how to render a page.
	 * The value must be an instance of {@link org.zkoss.zk.ui.sys.PageRenderer}.
	 * <p>Default: null (means auto). It is decided by
	 * {@link org.zkoss.zk.ui.metainfo.LanguageDefinition#getPageRenderer}.
	 * @since 5.0.0
	 */
	public static final String PAGE_RENDERER = "org.zkoss.zk.ui.page.renderer";

	/** A request attribute to indicate whether "no-cache" header is
	 * generated for the current desktop.
	 * If no-cache is generated, ZK will remove a desktop as soon
	 * as possible to save the use of memory.
	 *
	 * <p>This attribute is set if ZK loader sets Cache-Control=no-cache.
	 * However, if a ZUML page is included by other servlet (such as
	 * JSP and DSP), this attribute won't be set.
	 * If you set Cache-Control manually, you might also set
	 * this attribute to save the use of memroy.
	 *
	 * <pre><code>request.setAttribute(Attributes.NO_CACHE, Boolean.TRUE);</code></pre>
	 *
	 * <p>Since 5.0.8, if the zk.redrawCtrl parameter is specified with page
	 * (as described in {@link #PAGE_REDRAW_CONTROL}),
	 * it implies {@link #NO_CACHE}
	 *
	 * @since 3.0.1
	 */
	public static final String NO_CACHE = "org.zkoss.zk.desktop.nocache";

	//Session//
	/** A session attribute used to denote that
	 * the invalidation of a native session (such as HttpSession and
	 * PortletSession) does not invalidate ZK session.
	 * Rather it is intended to renew a session (and the ZK session still alive).
	 *
	 * <p>A typical case is so-called Session Fixation Protection.
	 * <pre><code>hsess.setAttribute(Attributes.RENEW_NATIVE_SESSION, Boolean.True);
	 * hsess.invalidate();
	 * hsess.removeAttribute(Attributes.RENEW_NATIVE_SESSION);
	 * </code></pre>
	 *
	 * @since 3.5.1
	 */
	public static final String RENEW_NATIVE_SESSION = "org.zkoss.zk.ui.renewNativeSession";
	
	//Library//
	/** A library property to indicate whether UUID shall not be recycled.
	 * <p>Default: false (i.e., not disabled).
	 * @since 5.0.3
	 */
	public static final String UUID_RECYCLE_DISABLED = "org.zkoss.zk.ui.uuidRecycle.disabled";

	/** A library property to specify the class used to patch the rendering
	 * result of a portlet.
	 * <p>Default: null (means no need of patch).
	 * <p>If specified, the class must implement {@link PageRenderPatch}.
	 * An example implementation is {@link org.zkoss.zkplus.liferay.JQueryRenderPatch}
	 * that delays the rendering of a ZK portlet to avoid the conflicts when
	 * using IE.
	 * @since 5.0.0
	 */
	public static final String PORTLET_RENDER_PATCH_CLASS = "org.zkoss.zk.portlet.PageRenderPatch.class";

	/** A library property to specify the timeout (in milliseconds) to
	 * wait for the activation.
	 * <p>Notice that, after timeout, the activation will restart automatically.
	 * That is, the value won't really affect the result (no aborting or other).
	 * It is designed to avoid the annoying warning messages found in some JVM.
	 * For example, IBM JVM shows a warning if wait() exceeds 10 minutes.
	 * To prevent the warning, you can set the value to less than 10 minutes.
	 * <p>Default: 120000 (unit: milliseconds)
	 * @since 5.0.3
	 */
	public static final String ACTIVATE_RETRY_DELAY = "org.zkoss.zk.ui.activate.wait.retry.timeout";

	//URI//
	/** A special prefix that is used if you want to inject a special
	 * fragment into the URI of a clss Web resource (CWR).
	 * The fragment is ignored with retrieving the file, so it can be anything
	 * to make the browser consider it as a different URI.
	 *
	 * <p>For example, {@link org.zkoss.zk.ui.util.ThemeProvider.Aide}
	 * is based on this prefix.
	 *
	 * <p>Notice that this prefix is currently supported only by the WCS files
	 * ({@link org.zkoss.zk.ui.http.WcsExtendlet}).
	 */
	public static final String INJECT_URI_PREFIX = "_zkiju-";

	/** An execution attribute to indicate that a page is rendering.
	 * @since 5.0.4
	 */
	public static final String PAGE_RENDERING = "org.zkoss.zk.ui.page.rendering";

	/** A component attribute used to indicate whether to enable the stubing of
	 * the native components.
	 * <p>By default, the native component will be stub-ized, i.e., replaced
	 * with a stateless component called {@link org.zkoss.zk.ui.sys.StubComponent},
	 * such that the memory footprint will be minimized.
	 * To stub-ize non-native, please use {@link org.zkoss.zk.ui.Component#setStubonly}.
	 * <p>Default: true. Though rarely, you could disable the stubing by
	 * setting this attribute to false. For example, if you have a component that
	 * has native childs, and you'd like to detach it and re-attach later.
	 * Since the server does not maintain the states, it cannot be restored when
	 * attached back.
	 * <p>It shall be set to a component's attribute, and it affects
	 * all descendant components unless it was set explicitly.
	 * <p>Default: true
	 * <p>Avaialbe in ZK EE only.
	 * @since 5.0.6
	 */
	public static final String STUB_NATIVE = "org.zkoss.zk.ui.stub.native";
	
	/** A session attribute used to store the ZK session in the native session. 
	 * @since 5.0.8
	 */
	public static final String ZK_SESSION = "javax.zkoss.zk.ui.Session";
}
