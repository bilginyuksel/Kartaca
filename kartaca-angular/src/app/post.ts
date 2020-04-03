export interface Post {
    id: number;
    place: string;
    note: string;
    imageUrl: string;
    createdTime: Date;
    createdBy: User;

}