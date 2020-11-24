<?xml version="1.0"?>
<recipe>

<instantiate from="src/app_package/classes/Fragment.kt.ftl"
                       to="${escapeXmlAttribute(srcOut)}/${folderName}/${activityClass}.kt" />


<instantiate from="src/app_package/classes/View.kt.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${folderName}/${className}MvpView.kt" />


<instantiate from="src/app_package/classes/Presenter.kt.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${folderName}/${className}Presenter.kt" />

<instantiate from="src/app_package/classes/MvpPresenter.kt.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${folderName}/${className}MvpPresenter.kt" />

<instantiate from="src/app_package/layout/fragment_layout.xml.ftl"
                 to="${escapeXmlAttribute(resOut)}/layout/${layoutName}.xml" />

                  <open file="${srcOut}/${folderName}/${className}MvpPresenter.kt"/>
                  <open file="${srcOut}/${folderName}/${className}MvpView.kt"/>
                  <open file="${srcOut}/${folderName}/${className}Presenter.kt"/>
                  <open file="${srcOut}/${folderName}/${activityClass}.kt"/>

</recipe>
