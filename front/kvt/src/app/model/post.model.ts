import { UserModel } from 'src/app/model/user.model';
import { CommentModel } from 'src/app/model/comment.model';
import { LikeModel } from 'src/app/model/like.model';
export class PostModel {
  postId!: number;
  postName: string;
  content!: string;
  creationDate!: Date;
  comments!: CommentModel[];
  likes!: LikeModel[];
  user!: UserModel;
}
