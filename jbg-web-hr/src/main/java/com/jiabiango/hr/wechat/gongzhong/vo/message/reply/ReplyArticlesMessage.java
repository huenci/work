package com.jiabiango.hr.wechat.gongzhong.vo.message.reply;

import java.util.ArrayList;
import java.util.List;

import com.jiabiango.hr.wechat.gongzhong.vo.message.Article;
import com.jiabiango.hr.wechat.gongzhong.vo.message.Message;


 
public class ReplyArticlesMessage extends Message {
	public static final String TYPE_NEWS = "news";
	private int articleCount = 0;
	private List<Article> articles = new ArrayList();

	public void setMsgType(String msgType) {
		if (!("news".equals(msgType)))
			throw new RuntimeException("msgType必须为：news");

		super.setMsgType(msgType);
	}

	public String getMsgType() {
		return "news";
	}

	public List<Article> getArticles() {
		return this.articles;
	}

	public int getArticleCount() {
		return this.articleCount;
	}

	public void addArticles(Article article) {
		if (this.articleCount > 10)
			throw new RuntimeException("图文消息个数，限制为10条以内");

		this.articles.add(article);
		this.articleCount = this.articles.size();
	}
}
