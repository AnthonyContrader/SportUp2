import { AppPage } from './app.po';
import { browser, logging, element, by } from 'protractor';

describe('my-angular5-app App', () => {
  let page: AppPage;
  beforeEach(() => {
    page = new AppPage();
  });
  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('SPORTUP');
  });
});