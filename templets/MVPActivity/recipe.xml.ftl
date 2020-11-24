<?xml version="1.0"?>
<recipe>

<instantiate from="src/app_package/View.kt.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${folderName}/${className}MvpView.kt" />

<instantiate from="src/app_package/Activity.kt.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${folderName}/${activityClass}.kt" />

<instantiate from="src/app_package/Presenter.kt.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${folderName}/${className}Presenter.kt" />

<instantiate from="src/app_package/MvpPresenter.kt.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${folderName}/${className}MvpPresenter.kt" />

<instantiate from="src/app_package/activity_layout.xml.ftl"
                 to="${escapeXmlAttribute(resOut)}/layout/${layoutName}.xml" />

<merge from="AndroidManifest.xml.ftl"
                 to="${escapeXmlAttribute(manifestOut)}/AndroidManifest.xml" />

                 <open file="${srcOut}/${folderName}/${className}MvpPresenter.kt"/>
                 <open file="${srcOut}/${folderName}/${className}MvpView.kt"/>
                 <open file="${srcOut}/${folderName}/${className}Presenter.kt"/>
                 <open file="${srcOut}/${folderName}/${activityClass}.kt"/>

</recipe>