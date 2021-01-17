<!--<?xml version="1.0" encoding="UTF-8"?>-->
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xs="http://www.w3.org/2001/XMLSchema" exclude-result-prefixes="xs" version="2.0">
    <xsl:output method="xml" version="1.0" encoding="UTF-8" indent="yes"/>

    <xsl:template match="/">
        <xsl:element name="Shell">
            <xsl:choose>
                <xsl:when test="ReceiptOrderForGoods != ''">
                    <xsl:element name="msgType">ORDER</xsl:element>
                    <xsl:element name="customer">
                        <xsl:value-of select="current()/ReceiptOrderForGoods/Customer"/>
                        <!--                        <xsl:apply-templates mode="customer" select="current()/ReceiptOrderForGoods/Customer"/>-->
                    </xsl:element>
                    <xsl:element name="order">
                        <xsl:apply-templates mode="order" select="current()"/>
                    </xsl:element>
                </xsl:when>
            </xsl:choose>
        </xsl:element>
    </xsl:template>

    <xsl:template mode="customer" match="Customer">
        <xsl:element name="customerrrr">
            <xsl:value-of select="current()"/>
        </xsl:element>
    </xsl:template>

    <xsl:template mode="order" match="ReceiptOrderForGoods">
        <!--        <xsl:element name="MsgType">Поставка</xsl:element>-->
        <!--        <xsl:element name="DDT">
            <xsl:value-of select="current()/Date"/>
            <xsl:text>T00:00:00.000</xsl:text>
        </xsl:element>
-->
        <xsl:element name="orderNo">
            <xsl:value-of select="current()/Number"/>
        </xsl:element>
        <xsl:element name="orderDate">
            <!--            <xsl:value-of select="current()/Date"/>-->
            <xsl:text>2021-01-17T11:51:23.206+03:00</xsl:text>
        </xsl:element>
        <xsl:element name="plannedDate">
            <!--            <xsl:value-of select="current()/PlannedDeliveryDate"/>-->
            <xsl:text>2021-01-17T11:51:23.206+03:00</xsl:text>
        </xsl:element>
        <xsl:element name="orderType">
            <xsl:value-of select="current()/OrderType"/>
        </xsl:element>
        <xsl:element name="deliveryType">
            <xsl:value-of select="current()/TypeOfDelivery"/>
        </xsl:element>

        <xsl:element name="contractor">
            <xsl:element name="code">
                <xsl:value-of select="current()/IDSupplier"/>
            </xsl:element>
            <xsl:element name="name">
                <xsl:value-of select="current()/NameSupplier"/>
            </xsl:element>
            <xsl:element name="adress">
                <xsl:value-of select="current()/AdressSupplier"/>
            </xsl:element>
        </xsl:element>

        <xsl:element name="vehicle">
            <xsl:element name="licencePlate">
                <xsl:value-of select="current()/NumberCar"/>
            </xsl:element>
            <xsl:element name="driver">
                <xsl:value-of select="current()/Driver"/>
            </xsl:element>
        </xsl:element>

        <xsl:for-each select="current()/Goods">
            <lineItem>
                <xsl:element name="lineNumber">
                    <xsl:value-of select="current()/LineNumber"/>
                </xsl:element>
                <xsl:element name="article">
                    <xsl:value-of select="current()/Article"/>
                </xsl:element>
                <xsl:element name="name">
                    <xsl:value-of select="current()/Name"/>
                </xsl:element>
                <xsl:element name="qty">
                    <xsl:value-of select="current()/Count"/>
                </xsl:element>
                <xsl:element name="category">
                    <xsl:value-of select="current()/Category"/>
                </xsl:element>
                <xsl:element name="mark2">
                    <xsl:value-of select="current()/Mark2"/>
                </xsl:element>
                <xsl:element name="comment">
                    <xsl:value-of select="current()/Comment"/>
                </xsl:element>
            </lineItem>
        </xsl:for-each>
    </xsl:template>
</xsl:stylesheet>
