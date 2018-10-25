package com.tritonsfs.springboot.crawler;

/**
 * @author 2018/10/25 16:30 by 刘赵强
 **/
import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;
import org.jsoup.nodes.Document;

public class demo extends BreadthCrawler {
    /**
     * @param crawlPath crawlPath is the path of the directory which maintains
     * information of this crawler
     * @param autoParse if autoParse is true,BreadthCrawler will auto extract
     * links which match regex rules from page
     */
    public demo(String crawlPath, boolean autoParse) {
        super(crawlPath, autoParse);
        /*start page*/
        this.addSeed("http://www.ttpai.cn/baozhang");
        /*fetch url like the value by setting up RegEx filter rule */
//        this.addRegex(".*");
        /*do not fetch jpg|png|gif*/
//        this.addRegex("-.*\\.(jpg|png|gif).*");
        /*do not fetch url contains #*/
//        this.addRegex("-.*#.*");
    }
    @Override
    public void visit(Page page, CrawlDatums next) {
        String url = page.getUrl();
        Document doc = page.getDoc();
        System.out.println(url);
        System.out.println(doc.title());
        String question=page.getDoc().select("div[class=aside-left]").select("h4[class=title]").text();
        System.out.println(question);
        /*If you want to add urls to crawl,add them to nextLink*/
        /*WebCollector automatically filters links that have been fetched before*/
        /*If autoParse is true and the link you add to nextLinks does not match the regex rules,the link will also been filtered.*/
        //next.add("http://gz.house.163.com/");
    }

    public static void main(String[] args) throws Exception {
        demo crawler = new demo("path", true);
        crawler.setThreads(50);
        crawler.setTopN(100);
        //crawler.setResumable(true);
        /*start crawl with depth 3*/
        crawler.start(3);
    }
}