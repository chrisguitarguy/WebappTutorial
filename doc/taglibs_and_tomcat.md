# Taglibs (like JSTL) & Apache Tomcat

Tomcat doesn't come with any JSTL tag libraries. If you need them on tomcat,
Apache has a set of taglibs you can grab and drop into `WEB-INF/lib`.

Add the follow dependencies into your `ivy.xml`.

    <dependency org="org.apache.taglibs" name="taglibs-standard-impl" rev="1.2.1" />
    <dependency org="org.apache.taglibs" name="taglibs-standard-spec" rev="1.2.1" />

You'll need both. `taglibs-standard-spec` contains the `javax.servlet.jsp.jstl`
interfaces and implementation. Since Tomcat does come with any of that stuff, no
conflicts should happen.

`taglibs-standard-impl` is where all the implementations reside. If you look
inside its `.jar` file, you'll find a set of `*.tld` files in its `META-INF`.
Tomcat loads these for you, no futher action (or `web.xml` configuration) is
necessary.

If you need to know how to use the taglibs, the `*.tld` files are really useful.
Each describes everything about the tag (and has things like the URL to import,
etc).
