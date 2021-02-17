package model.data_structures;

public class YoutubeVideo implements Comparable<YoutubeVideo>  
{
	
	
	
	
	private String videoId;
	private int trendingDate;
	private String Title;
	private String channelTitle;
	private String categoryId;
	private String publishTime;
	private String tags;
	private String views;
	private String likes;
	private String dislikes;
	private String commentCount;
	private String thumbnailLink;
	private String comments;
	private String ratingsDisabled;
	private String viodeoError;
	private String description;
	private String country;
	
	public YoutubeVideo (String pvideoId, int ptrendingDate, String pTitle, String pchannelTitle, String pcategoryId, String ppublishTime, String ptags, String pViews, String pLikes, String pDislikes, String pcommentCount, String pthumbnailLink, String pcomments, String pratingsDisabled, String pviodeoError, String pdescription, String pcountry)
	{
		videoId =pvideoId;
		trendingDate= ptrendingDate;
		Title=pTitle;
		channelTitle=pchannelTitle;
		categoryId=pcategoryId;
		publishTime=ppublishTime;
		tags=ptags;
		views=pViews;
		likes=pLikes;
		dislikes=pDislikes;
		commentCount=pcommentCount;
		thumbnailLink=pthumbnailLink;
		comments=pcomments;
		ratingsDisabled=pratingsDisabled;
		viodeoError=pviodeoError;
		description=pdescription;
		country=pcountry;
		
		
	}
	
	public String darvideoId()
	{
		return videoId;
	}
	public int dartrendingDate()
	{
		return trendingDate;
	}
	public String darTitle()
	{
		return Title;
	}
	public String darchannelTitle()
	{
		return channelTitle;
	}
	public String darcategoryId()
	{
		return categoryId;
	}
	public String darpublishTime()
	{
		return publishTime;
	}
	public String dartags()
	{
		return tags;
	}
	public String darviews()
	{
		return views;
	}
	public String darlikes()
	{
		return likes;
	}
	public String dardislikes()
	{
		return dislikes;
	}
	public String darcommentCount()
	{
		return commentCount;
	}
	public String darthumbnailLink()
	{
		return thumbnailLink;
	}
	public String darcomments()
	{
		return comments;
	}
	public String darratingsDisabled()
	{
		return dislikes;
	}
	public String darviodeoError()
	{
		return viodeoError;
	}
	public String dardescription()
	{
		return description;
	}
	public String darcountry()
	{
		return country;
	}
	
	
	
	@Override
	public int compareTo(YoutubeVideo o) {


		int x = dartrendingDate(); 
		if (o.dartrendingDate()> dartrendingDate())return -1;
		if (o.dartrendingDate()<= dartrendingDate())return 1;
		return 0;
	}

}
