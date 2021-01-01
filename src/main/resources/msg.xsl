<!--<?xml version="1.0" encoding="UTF-8"?>-->
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xs="http://www.w3.org/2001/XMLSchema" exclude-result-prefixes="xs" version="2.0">
    <xsl:output method="xml" version="1.0" encoding="UTF-8" indent="yes"/>
    <xsl:template match="/">
        <xsl:choose>
            <xsl:when test="ReceiptOrderForGoods != ''">
                <xsl:element name="Order">
                    <xsl:apply-templates mode="UP" select="current()"/>
                </xsl:element>
            </xsl:when>
        </xsl:choose>
    </xsl:template>

    <xsl:template mode="UP" match="ReceiptOrderForGoods">
        <xsl:element name="MsgType">In</xsl:element>
        <xsl:element name="Doc">
            <xsl:value-of select="current()/Number"/>
        </xsl:element>
        <xsl:element name="Mail">
            <xsl:value-of select="current()/Mail"/>
        </xsl:element>
        <Products>
            <xsl:for-each select="current()/Goods">
                <Product>
                    <xsl:element name="LineNumber">
                        <xsl:value-of select="current()/LineNumber"/>
                    </xsl:element>
                    <xsl:element name="ProductName">
                        <xsl:value-of select="current()/Name"/>
                    </xsl:element>
                    <xsl:element name="Category">
                        <xsl:value-of select="current()/Category"/>
                    </xsl:element>
                    <xsl:element name="Mark2">
                        <xsl:value-of select="current()/Mark2"/>
                    </xsl:element>
                    <xsl:element name="Qty">
                        <xsl:value-of select="current()/Count"/>
                    </xsl:element>
                    <xsl:element name="Comment">
                        <xsl:value-of select="current()/Comment"/>
                    </xsl:element>
                    <xsl:element name="Article">
                        <xsl:value-of select="current()/Article"/>
                    </xsl:element>
                </Product>
            </xsl:for-each>
        </Products>
    </xsl:template>
</xsl:stylesheet>