package com.ktree.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.wiki.service.WikiPageLocalServiceUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.ProcessAction;

import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=KTree",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Ktree Liferay OSGI Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class KtreeLiferayOsgiPortlet extends MVCPortlet {
	@ProcessAction(name="addContentToWiki")
	public void addContentToWiki(ActionRequest actionRequest,ActionResponse actionResponse) throws PortalException{
		String htmlContent = ParamUtil.getString(actionRequest, "wikiEditor");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		WikiPageLocalServiceUtil.addPage(themeDisplay.getUserId(), 123, "First Wiki", 1.0, htmlContent, "", false, "html", true, "FrontPage", "", new ServiceContext());
		System.out.println(WikiPageLocalServiceUtil.getWikiPagesCount());
		
	}
}