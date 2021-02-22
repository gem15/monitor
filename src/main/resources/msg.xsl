<!--<?xml version="1.0" encoding="UTF-8"?>-->
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:xs="http://www.w3.org/2001/XMLSchema" exclude-result-prefixes="xs" version="2.0">
    <xsl:output method="xml" version="1.0" encoding="UTF-8" indent="yes"/>

    <!--    <xsl:template match="Shell">
        <xsl:element name="msgType">ZZZZ</xsl:element>
        <xsl:copy><xsl:apply-templates select="@*|node()" /></xsl:copy>
<!-\-        <xsl:copy>
            <xsl:apply-templates select="@*|node()"/>
            <!-\\-Do something special for Node766, like add a certain string-\\->
            <xsl:text> add some text </xsl:text>
        </xsl:copy>
-\->
    </xsl:template>
-->
    <xsl:template match="/">

        <Shell xmlns="http://www.sevtrans.com">
            <!--        <xsl:element name="Shell">-->
            <xsl:choose>
<!--
                <xsl:when test="Shell != ''">
                    <xsl:element name="msgType">shipment</xsl:element>
                    <xsl:copy-of select="current()/Shell"/>
                </xsl:when>
-->
                <xsl:when test="ReceiptOrderForGoods != ''">
                    <xsl:element name="msgType">delivery</xsl:element>
                    <xsl:element name="customerID">
                        <xsl:value-of select="current()/ReceiptOrderForGoods/VN"/>
                    </xsl:element>
                    <xsl:element name="customer">
                        <xsl:value-of select="current()/ReceiptOrderForGoods/Customer"/>
                        <!--                        <xsl:apply-templates mode="customer" select="current()/ReceiptOrderForGoods/Customer"/>-->
                    </xsl:element>
                    <xsl:apply-templates mode="delivery" select="current()"/>
                </xsl:when>

                <xsl:when test="ExpenditureOrderForGoods != ''">
                    <xsl:element name="msgType">shipment</xsl:element>
                    <xsl:element name="customerID">
                        <xsl:value-of select="current()/ExpenditureOrderForGoods/VN"/>
                    </xsl:element>
                    <xsl:element name="customer">
                        <xsl:value-of select="current()/ExpenditureOrderForGoods/Customer"/>
                    </xsl:element>
                    <xsl:element name="shipmentOrder">
                        <xsl:apply-templates mode="shipment" select="current()"/>
                    </xsl:element>
                </xsl:when>

                <xsl:when test="AddingGoods != ''">
                    <xsl:element name="msgType">sku</xsl:element>
                    <xsl:element name="customerID">
                        <xsl:value-of select="current()/AddingGoods/VN"/>
                    </xsl:element>
                    <xsl:element name="sku">
                        <xsl:apply-templates mode="addingGoods" select="current()"/>
                    </xsl:element>
                </xsl:when>
            </xsl:choose>
        </Shell>
        <!--        </xsl:element>-->
    </xsl:template>

    <!--Test-->
    <xsl:template mode="customer" match="Customer">
        <xsl:element name="customerrrr">
            <xsl:value-of select="current()"/>
        </xsl:element>
    </xsl:template>

    <xsl:template mode="addingGoods" match="AddingGoods">
        <xsl:element name="article">
            <xsl:value-of select="current()/ARTICLE"/>
        </xsl:element>
        <xsl:element name="upc">
            <xsl:value-of select="current()/UPC"/>
        </xsl:element>
        <xsl:element name="name">
            <xsl:value-of select="current()/NAME"/>
        </xsl:element>
        <xsl:element name="uofm">
            <xsl:value-of select="current()/MEASURE"/>
        </xsl:element>
        <xsl:element name="storageLife">
            <xsl:value-of select="current()/PRODUCT_LIFE"/>
        </xsl:element>
        <xsl:element name="storageCondition">
            <xsl:value-of select="current()/STORAGE_POS"/>
        </xsl:element>
        <xsl:element name="productType">
            <xsl:value-of select="current()/BILLING_CLASS"/>
        </xsl:element>

        <!--        <ARTICLE>COGENT1</ARTICLE>
        <UPC>2000001720875</UPC>
        <NAME>Матрас</NAME>
        <MEASURE>шт</MEASURE>
        <PRODUCT_LIFE>180</PRODUCT_LIFE>
        <STORAGE_POS>НОРМ</STORAGE_POS>
        <BILLING_CLASS>НЗ</BILLING_CLASS>
-->
    </xsl:template>

    <xsl:template name="order" xmlns="http://www.sevtrans.com">
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
    </xsl:template>


    <xsl:template mode="lineItems" match="Goods">
        <lineItem xmlns="http://www.sevtrans.com">
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
    </xsl:template>

    <xsl:template mode="delivery" match="ReceiptOrderForGoods">
        <!--        <xsl:element name="DDT">
            <xsl:value-of select="current()/Date"/>
            <xsl:text>T00:00:00.000</xsl:text>
        </xsl:element>
-->
        <deliveryOrder xmlns="http://www.sevtrans.com">
            <xsl:call-template name="order"/>
            <!--
                        <xsl:element name="orderNo">
                            <xsl:value-of select="current()/Number"/>
                        </xsl:element>
                        <xsl:element name="orderDate">
                            &lt;!&ndash;            <xsl:value-of select="current()/Date"/>&ndash;&gt;
                            <xsl:text>2021-01-17T11:51:23.206+03:00</xsl:text>
                        </xsl:element>
                        <xsl:element name="plannedDate">
                            &lt;!&ndash;            <xsl:value-of select="current()/PlannedDeliveryDate"/>&ndash;&gt;
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
            -->
            <xsl:apply-templates mode="lineItems" select="current()/Goods"/>
        </deliveryOrder>
        <!--        <xsl:for-each select="current()/Goods">
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
-->
    </xsl:template>

    <xsl:template mode="shipment" match="ExpenditureOrderForGoods">
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
                <xsl:value-of select="current()/IDConsignee"/>
            </xsl:element>
            <xsl:element name="name">
                <xsl:value-of select="current()/NameConsignee"/>
            </xsl:element>
            <xsl:element name="adress">
                <xsl:value-of select="current()/AdressConsignee"/>
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
        <xsl:apply-templates mode="lineItems" select="current()/Goods"/>
    </xsl:template>
</xsl:stylesheet>
