package com.ss.ita.greencity.ui.pages.news;

import com.ss.ita.greencity.ui.elements.*;
import com.ss.ita.greencity.ui.locators.NewsLocators;
import com.ss.ita.greencity.ui.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.ss.ita.greencity.ui.locators.NewsListCommentsLocators.*;

import static com.ss.ita.greencity.ui.locators.NewsListCommentsLocators.COMMENT_TEXT;
import static com.ss.ita.greencity.ui.locators.NewsLocators.*;
import static com.ss.ita.greencity.ui.locators.NewsLocators.LIKE_COUNT;

public class NewsListCommentComponent extends BasePage {

    private WebElement root;
    private Button nextReplies;
    private TextArea replyInput;
    private Button postReply;
    private TextArea editCommentField;
    private Button viewReplies;
    private Button acceptReply;
    private Input editReplyHolder;
    private Button editReplyButton;
    private Button saveChangesButton;
    private Label editedReplyMessage;
    private Label content;
    private Span likesCount;
    private Button like;

    WebDriverWait wait = new WebDriverWait(driver, 10);

	public NewsListCommentComponent(WebDriver driver, WebElement root) {
		super(driver);
		this.root = root;
	}

    public NewsListCommentComponent createOneReplyToComment(String replyText) {
        return clickReplyButton().createAnotherReply(replyText).clearReplyTextArea();
    }

	public NewsListCommentComponent clearReplyTextArea() {
		getReplyInput().clickTextArea();
		getReplyInput().clearTextArea();
		return this;
	}

	public int numberOfReplies() {
		int count = driver.findElements(By.xpath("//div[contains(@class,'comment-body-wrapper wrapper-reply')]"))
				.size();
		return count;
	}

    public NewsListCommentComponent clickViewReplyButton() {
        driver.findElement(VIEW_REPLY_BUTTON.getPath()).click();
        return this;
    }

    public String getTextFromReply() {
        if (editedReplyMessage == null) {
            editedReplyMessage = new Label(driver, EDITED_REPLY_MESSAGE);
        }
        return editedReplyMessage.getText();
    }

    public NewsListCommentComponent clickReplyButton() {
        driver.findElement(REPLY_FIRST_COMMENT_BUTTON.getPath()).click();
        return this;
    }

    public NewsListCommentComponent createAnotherReply(String replyText) {
        new NewsListCommentComponent(driver, root)
                .setReplyText(replyText)
                .clickPublishReplyButton()
                .clearReplyTextArea();
        return this;
    }

    public Button getApproveReplyButton() {
        if (acceptReply == null) {
            acceptReply = new Button(driver, ACCEPT_REPLY_HOLDER);
        }
        return acceptReply;
    }

    public NewsListCommentComponent setReplyText(String replyText) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[contains(@class,'invalid')]")));
        getReplyInput()
                .sendKeysTextArea(replyText);
        return this;
    }


    public NewsListCommentComponent clickNextRepliesButton() {
        getNextRepliesButton().clickButton();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.
                numberOfElementsToBeLessThan(By.xpath("//div[contains(@class,'comment-body-wrapper wrapper-reply')]"), 10));
        return this;
    }

    public Button getNextRepliesButton() {
        if (nextReplies == null) {
            nextReplies = new Button(driver, NEXT_REPLIES_BUTTON);
        }
        return nextReplies;
    }

    public TextArea getReplyInput() {
        if (replyInput == null) {
            replyInput = new TextArea(driver, REPLY_TEXT_AREA);
        }
        return replyInput;
    }

    public NewsListCommentComponent clickPublishReplyButton() {
        driver.findElement(PUBLISH_REPLY_BUTTON.getPath()).click();
        return this;
    }

    public int numbersOfComments() {

        int count = driver.findElements(By.xpath("//p[contains(@class,'comment-text')]")).size();
        return count;
    }

    public void waitForCommentAction(Integer timeout) {
        // Current comments count
        int count_before = numbersOfComments();

        int loops_count = 0;
        while (true) {
            loops_count += 1;

            //Actual comments count
            int actual_count = numbersOfComments();

            // ASAP comment's count was changed - break out from while loop
            if (count_before != actual_count) {
                break;
            }

            // Throw exception if comment's number wasn't changed during timeout period
            if (loops_count == timeout) {
                throw new TimeoutException("Comment count wasn't changed after " + loops_count + " seconds!");
            }

            // Wait 1 second per iteration
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }


    public NewsPage deleteFirstComment() {
        clickDeleteCommentButton().clickApproveDeletingCommentButton().waitForCommentAction(10);
        return new NewsPage(driver);
    }

    public NewsListCommentComponent clickDeleteCommentButton() {
        driver.findElement(DELETE_FIRST_COMMENT_BUTTON.getPath()).click();
        return this;
    }

    public NewsListCommentComponent clickApproveDeletingCommentButton() {
        driver.findElement(APPROVE_DELETING_COMMENT_BUTTON.getPath()).click();
        return this;
    }

    public Button getPublishReplyButton() {
        if (postReply == null) {
            postReply = new Button(driver, PUBLISH_REPLY_BUTTON);
        }
        return postReply;
      
	public TextArea getReplyInput() {
		if (replyInput == null) {
			replyInput = new TextArea(driver, REPLY_TEXT_AREA);
		}
		return replyInput;
	}

	public NewsListCommentComponent clickPublishReplyButton() {
		driver.findElement(PUBLISH_REPLY_BUTTON.getPath()).click();
		return this;
	}

	public int numbersOfComments() {

		int count = driver.findElements(By.xpath("//p[contains(@class,'comment-text')]")).size();
		return count;
	}

	public void waitForCommentAction(Integer timeout) {
		// Current comments count
		int count_before = numbersOfComments();

		int loops_count = 0;
		while (true) {
			loops_count += 1;

			// Actual comments count
			int actual_count = numbersOfComments();

			// ASAP comment's count was changed - break out from while loop
			if (count_before != actual_count) {
				break;
			}

			// Throw exception if comment's number wasn't changed during timeout period
			if (loops_count == timeout) {
				throw new TimeoutException("Comment count wasn't changed after " + loops_count + " seconds!");
			}

			// Wait 1 second per iteration
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
		}
	}

	public NewsPage deleteFirstComment() {
		clickDeleteCommentButton().clickApproveDeletingCommentButton().waitForCommentAction(10);
		return new NewsPage(driver);
	}

	public NewsListCommentComponent clickDeleteCommentButton() {
		driver.findElement(DELETE_FIRST_COMMENT_BUTTON.getPath()).click();
		return this;
	}

	public NewsListCommentComponent clickApproveDeletingCommentButton() {
		driver.findElement(APPROVE_DELETING_COMMENT_BUTTON.getPath()).click();
		return this;
	}

	public Button getPublishReplyButton() {
		if (postReply == null) {
			postReply = new Button(driver, PUBLISH_REPLY_BUTTON);
		}
		return postReply;
	}

	// Edit methods

	public NewsListCommentComponent clickEditComment() {
		new Button(driver, EDIT_COMMENT_BUTTON).clickButton();
		return this;
	}

	public NewsListCommentComponent setEditFieldText(String text) {
		editCommentField = new TextArea(driver, EDIT_COMMENT_FIELD);
		editCommentField.sendKeysTextArea(text);
		return this;
	}

	public NewsListCommentComponent clickSaveChangesButton() {
		new Button(driver, EDIT_SAVE_COMMENT_BUTTON).clickButton();
		return this;
	}

	// general method
	public NewsListCommentComponent editComment(String newText) {
		return clickEditComment().setEditFieldText(newText).clickSaveChangesButton();
	}

	public Label getContent() {
		return new Label(root.findElement(COMMENT_TEXT.getPath()));
	}

	public Span getSpanLikesCount() {
		if (likesCount == null) {
			likesCount = new Span(driver, LIKE_COUNT);
		}
		return likesCount;
	}

	public String getLikesCount() {
    	return getSpanLikesCount().getText();
	}

    public Button getLikeButton() {
    	if(like == null) {
    		like = new Button(driver,NewsLocators.LIKE_BUTTON);
    	}
    	return like;
    }

    public NewsListCommentComponent pressLikeButton() {
    	getLikeButton().clickButton();
    	return new NewsListCommentComponent(driver, root);
    }


    public void clickOnEditReplyHolder() {
        getEditReplyHolder().clickInput();
    }


    public Button getSaveChangesButton() {
        if (saveChangesButton == null) {
            saveChangesButton = new Button(driver, SAVE_CHANGES_BUTTON);
        }
        return saveChangesButton;
    }

    public Button getViewReplies() {
        if (viewReplies == null) {
            viewReplies = new Button(driver, VIEW_REPLIES);
        }
        return viewReplies;
    }

    public void clickOnSaveChangesButton() {
        getSaveChangesButton().clickButton();
    }

    public void clickOnGetViewReplies() {
        getViewReplies().clickButton();
    }

    public Button getEditReplyButton() {
        if (editReplyButton == null) {
            editReplyButton = new Button(driver, EDIT_REPLY_BUTTON);
        }
        return editReplyButton;
    }

    public void clickOnEditReplyButton() {
        getEditReplyButton().clickButton();
    }

    public Input getEditReplyHolder() {
        if (editReplyHolder == null) {
            editReplyHolder = new Input(driver, EDIT_REPLY_HOLDER);
        }
        return editReplyHolder;
    }

    public NewsListCommentComponent editReply(String editMessage) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[text()=' Reply ']")));
        clickOnGetViewReplies();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Hide')]")));
        clickOnEditReplyButton();
        clickOnEditReplyHolder();
        getEditReplyHolder().sendKeys(editMessage);
        clickOnSaveChangesButton();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[text() =' Save changes ']")));
        return this;
    }
}
